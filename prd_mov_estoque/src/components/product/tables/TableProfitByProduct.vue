<template>
  <div class="q-pa-md">
    <div class="text-center text-subtitle text-bold">
      PROFIT BY PRODUCT
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

          <q-td key="type" :props="props">
            {{ props.row.type }}
          </q-td>

          <q-td key="supplierValue" :props="props" class="text-green">
            R$ {{ parseFloat(props.row.supplierValue).toFixed(2) }}
          </q-td>

          <q-td key="sellingPrice" :props="props" class="text-green">
            R$ {{ parseFloat(props.row.sellingPrice).toFixed(2) }}
          </q-td>

          <q-td key="stockOut" :props="props">
            {{ props.row.stockOut }}
          </q-td>

          <q-td key="stock" :props="props">
            {{ props.row.stock }}
          </q-td>

          <q-td
            key="profit"
            :props="props"
            :class="parseFloat(props.row.profit).toFixed(2) <= 0 ? 'text-red' : 'text-green'"
          >
            R$ {{ parseFloat(props.row.profit).toFixed(2)}}
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
        { name: 'type', label: 'Type', field: 'type', align: 'left', sortable: true },
        { name: 'supplierValue', label: 'Supplier Value', field: 'supplierValue', align: 'left', sortable: true },
        { name: 'sellingPrice', label: 'Selling Price', field: 'sellingPrice', align: 'left', sortable: true },
        { name: 'stockOut', label: 'Stock Out', field: 'stockOut', align: 'left', sortable: true },
        { name: 'stock', label: 'Stock', field: 'stock', align: 'left', sortable: true },
        { name: 'profit', label: 'Profit', field: 'profit', align: 'left', sortable: true },
      ],
      rows: [
        {
          id: 1,
          description: 'TV',
          type: 'Home',
          supplierValue: 240.00,
          sellingPrice:300.00,
          stockOut: 1,
          stock: 10,
          profit: -10.00
        },
      ]
    }
  },
  components:{
    SelectTypeProduct
  },
  methods:{
    getAllProfitByProduct(){
      //TODO: metodo lucro por produto
    }
  },
})
</script>
