<template>
  <div class="q-pa-md">
    <div class="text-center text-subtitle text-bold">
      PRODUCT BY TYPE
      <SelectTypeProduct
        v-model="typeProduct"
        label="Type Product"
        @update:model-value="getAllProductsByType(typeProduct)"
      />
    </div>
    <q-table
      :rows="rows"
      :columns="columns"
      row-key="name"
    >
      <template v-slot:body="props">
        <q-tr :props="props">
          <q-td key="id" :props="props">
            {{ props.row.id }}
          </q-td>

          <q-td key="description" :props="props">
            {{ props.row.description }}
          </q-td>

          <q-td key="stock" :props="props">
            {{ props.row.stock }}
          </q-td>

            <q-td key="sales" :props="props">
            {{ props.row.sales }}
          </q-td>
        </q-tr>
      </template>
    </q-table>
  </div>

</template>
<script>
import { defineComponent } from 'vue';
import SelectTypeProduct from '../inputs/SelectTypeProduct.vue';
export default defineComponent({
  data(){
    return {
      typeProduct: null,
      columns:[
        { name: 'id', label: 'Id', field: 'id', align: 'left', sortable: true },
        { name: 'description', label: 'Description', field: 'description', align: 'left', sortable: true },
        { name: 'stock', label: 'Stock', field: 'stock', align: 'left', sortable: true },
        { name: 'sales', label: 'Sales', field: 'sales', align: 'left', sortable: true },
      ],
      rows: []
    }
  },
  components:{
    SelectTypeProduct
  },
  methods:{
    getAllProductsByType(typeProduct){
      this.$api.get(`products/current-stock?productType=${typeProduct}`)
      .then((res) => {
        if (res.status === 200) {
          this.rows = res.data;
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
})
</script>
