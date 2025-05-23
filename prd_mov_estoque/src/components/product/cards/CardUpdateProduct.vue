<template>
  <q-card>
    <q-card-section>
      <q-form @submit="updateProduct(id, description, value, type)" ref="form">
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
      id: null
    }
  },
  components:{
    InputProduct,
    SelectTypeProduct
  },
  methods:{
    updateProduct(id, description, value, type){

      // TODO:Método de Editar Produto
      console.log(id);
      console.log(description);
      console.log(parseFloat(value).toFixed(2));
      console.log(type);
    },

    initialVariables(produtoRouteParams){
      this.id = produtoRouteParams.id;
      this.description = produtoRouteParams.description;
      this.value = parseFloat(produtoRouteParams.supplierValue).toFixed(2);
      this.type = produtoRouteParams.type;
    }
  },
  mounted(){
    const produtoRouteParams = JSON.parse(this.$route.query.product);
    this.initialVariables(produtoRouteParams)
  }
})
</script>
