<template>
  <q-card>
    <q-card-section>
      <q-form @submit="createMovement(productId, saleValue, type, stock, saleDate)" ref="form">
        <div class="q-gutter-md">

          <div class="text-subtitle2 text-bold text-center">
            CREATE MOVEMENT
          </div>

          <InputProduct
            label="product"
            v-model="product"
            :rules="[val => !!val || 'Product is mandatory']"
            disable
          />

          <SelectTypeMovement
            v-model="type"
            :rules="[val => !!val || 'Type is mandatory']"
          />

          <div class="text-grey caption q-mt-none q-pt-none">
            Value Supplier: {{ parseFloat(this.supplierValue).toFixed(2) }}
          </div>
          <InputProduct
            v-show="type === 'OUT'"
            label="Sale Value"
            v-model="saleValue"
            type="number"
            :rules="[
              val => !!val || 'Value is mandatory',
              val => parseFloat(val) > 0 || 'Value must be greater than 0'
            ]"
          />

          <InputProduct
            label="stock"
            v-model="stock"
            type="number"
            :rules="[
              val => !!val || 'Value is mandatory',
              val => parseFloat(val) > 0 || 'Value must be greater than 0'
            ]"
          />

          <InputProduct
            v-show="type === 'OUT'"
            v-model="saleDate"
            filled
            type="date"
            hint="Native date"
             :rules="[
              val => !!val || 'Value is mandatory',
            ]"
          />

          <div>
            <q-btn
              class="full-width text-bold"
              label="Save"
              color="positive"
              icon="save"
              type="submit"
            />
          </div>
        </div>
      </q-form>

    </q-card-section>
  </q-card>

</template>
<script>
import InputProduct from 'src/components/product/inputs/InputProduct.vue';
import SelectTypeMovement from '../inputs/SelectTypeMovement.vue';
import { defineComponent } from 'vue';

export default defineComponent({
  data(){
    return {
      productId: null,
      product: null,
      saleValue: 0.00,
      stock: 0,
      type: null,
      supplierValue: 0,
      saleDate: null
    }
  },
  components:{
    InputProduct,
    SelectTypeMovement
  },
  methods:{

    createSale(){
       this.$api.post(`stock-operations/sale"`,{
        productId: productId,
        saleValue: saleValue,
        saleDate: saleDate,
        amount: stock,
      })
      .then((res) => {
        if (res.status === 201) {
          this.$q.notify({
            closeBtn: true,
            timeout: 3000,
            message: "movement sale successfully created",
            type: "positive",
          });

          setTimeout(() => {
            window.location.href = '/';
          }, 2000);
        }
        else {
          this.$q.notify({
            closeBtn: true,
            timeout: 3000,
            message: "Error.",
            type: "negative",
          });
        }
      })
      .catch((error) => {
        this.$q.notify({
          closeBtn: true,
          timeout: 3000,
          message: `Error: ${error.message}`,
          type: "negative",
        });
      });
    },

    incrementStock(){
      this.$api.post(`products`,{
        description: description,
        type: type,
        amount: stock,
        supplierValue: value,
      })
      .then((res) => {
        if (res.status === 201) {
          this.$q.notify({
            closeBtn: true,
            timeout: 3000,
            message: "product successfully created",
            type: "positive",
          });

          setTimeout(() => {
            window.location.href = '/';
          }, 2000);
        }
        else {
          this.$q.notify({
            closeBtn: true,
            timeout: 3000,
            message: "Error.",
            type: "negative",
          });
        }
      })
      .catch((error) => {
        this.$q.notify({
          closeBtn: true,
          timeout: 3000,
          message: `Error: ${error.message}`,
          type: "negative",
        });
      });
    },

    createMovement(productId, saleValue, type, stock, saleDate){
      if(type == 'OUT'){
        this.createSale();
      }
      else{
        this.incrementStock();
      }

    },

    initialVariables(produtoRouteParams){
      this.product = produtoRouteParams.description;
      this.productId = produtoRouteParams.id;
      this.supplierValue = produtoRouteParams.supplierValue;
    }
  },
  mounted(){
    const produtoRouteParams = JSON.parse(this.$route.query.product);
    this.initialVariables(produtoRouteParams)
  }
})
</script>
<style>
.caption{
  font-size: 10px;
}
</style>
