<template>
  <q-card>
    <q-card-section>
      <q-form @submit="updateProduct(id, description, value, type, stock)" ref="form">
        <div class="q-gutter-md">
          <div class="text-subtitle2 text-bold text-center">
            UPDATE PRODUCT
          </div>

          <InputProduct
            label="description"
            v-model="description"
            :rules="[val => !!val || 'Description is mandatory']"
          />

          <InputProduct
            label="value"
            v-model="value"
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
              val => parseFloat(val) > 0 || 'Stock must be greater than 0'
            ]"
          />

          <SelectTypeProduct
            v-model="type"
            :rules="[val => !!val || 'Type is mandatory']"
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
import InputProduct from '../inputs/InputProduct.vue';
import SelectTypeProduct from '../inputs/SelectTypeProduct.vue';
import { defineComponent } from 'vue';

export default defineComponent({
  data(){
    return {
      description: null,
      value: null,
      type:null,
      id: null,
      stock: null,
    }
  },
  components:{
    InputProduct,
    SelectTypeProduct
  },
  methods:{
    updateProduct(id, description, supplierValue, type, stock){
      this.$api.put(`products/${id}`,{
        description: description,
        type: type,
        amount: stock,
        supplierValue: supplierValue,
      })
      .then((res) => {
        if (res.status === 200) {
          this.$q.notify({
            closeBtn: true,
            timeout: 3000,
            message: "product successfully updated",
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

    initialVariables(product){
      this.description = product.description;
      this.value = parseFloat(product.supplierValue).toFixed(2);
      this.type = product.type;
      this.stock = product.stock;
    },

    getProductById(idProduct){
      this.$api.get(`products/${idProduct}`)
      .then((res) => {
        if (res.status === 200) {
          this.initialVariables(res.data);

          if (res.data.length === 0) {
            this.$q.notify({
              closeBtn: true,
              timeout: 3000,
              message: "Product not found.",
              type: "warning",
            });
          }
        } else {
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
    }
  },
  mounted(){
    this.id = JSON.parse(this.$route.query.product);
    this.getProductById(this.id);
  }
})
</script>
