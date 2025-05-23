<template>
  <q-card>
    <q-card-section>
      <q-form @submit="createMovement(product, sellingPrice, type, stock)" ref="form">
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
            label="Selling Price"
            v-model="sellingPrice"
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
      idProduct: null,
      product: null,
      sellingPrice: 0.00,
      stock: 0,
      type: null,
      supplierValue: 0,
    }
  },
  components:{
    InputProduct,
    SelectTypeMovement
  },
  methods:{
    createMovement(product, sellingPrice, type, stock){
      // TODO:Método de adicionar
      console.log(product);
      console.log(sellingPrice);
      console.log(type);
      console.log(stock);
    },

    initialVariables(produtoRouteParams){
      this.product = produtoRouteParams.description;
      this.idProduct = produtoRouteParams.id;
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
