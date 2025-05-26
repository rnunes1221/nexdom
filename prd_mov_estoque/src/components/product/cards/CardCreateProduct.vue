<template>
  <q-card>
    <q-card-section>
      <q-form @submit="createProduct(description, value, type, stock)" ref="form">
        <div class="q-gutter-md">

          <div class="text-subtitle2 text-bold text-center">
            CREATE PRODUCT
          </div>

          <InputProduct
            label="description"
            v-model="description"
            @update:model-value="description = $event.toUpperCase()"
            :rules="[val => !!val || 'Description is mandatory']"
          />

          <InputProduct
            label="value"
            v-model="value"
            type="number"
            :rules="[
              val => !!val || 'Value is Mandatory',
              val => parseFloat(val) > 0 || 'Value must be greater than 0'
            ]"
          />

          <SelectTypeProduct
            v-model="type"
            :rules="[val => !!val || 'Type is Mandatory']"
          />

          <InputProduct
            label="stock"
            v-model="stock"
            type="number"
            :rules="[
              val => !!val || 'Stock is Mandatory',
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
import InputProduct from '../inputs/InputProduct.vue';
import SelectTypeProduct from '../inputs/SelectTypeProduct.vue';
import { defineComponent } from 'vue';

export default defineComponent({
  data(){
    return {
      description: null,
      value: 0.00,
      stock: 0,
      type: null
    }
  },
  components:{
    InputProduct,
    SelectTypeProduct
  },
  methods:{
    createProduct(description, value, type, stock){
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
    }
  }
})
</script>
