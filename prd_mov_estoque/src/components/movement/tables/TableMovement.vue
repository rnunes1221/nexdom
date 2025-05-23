<template>
  <div class="q-pa-md">
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

          <q-td key="descriptionProduct" :props="props">
            {{ props.row.descriptionProduct }}
          </q-td>

          <q-td key="typeMovement" :props="props">
            {{ props.row.typeMovement }}
          </q-td>

          <q-td key="sellingPrice" :props="props" class="text-green">
            R$ {{ parseFloat(props.row.sellingPrice).toFixed(2) }}
          </q-td>

          <q-td key="salesData" :props="props">
            {{ props.row.salesData }}
          </q-td>

          <q-td key="stockMov" :props="props">
            {{ props.row.stockMov }}
          </q-td>
        </q-tr>
      </template>
    </q-table>
  </div>
</template>
<script>
import { defineComponent } from 'vue';

export default defineComponent({
  data(){
    return {
      columns:[
        { name: 'id', label: 'id', field: 'id', align: 'left', sortable: true },
        { name: 'descriptionProduct', label: 'Description Product', field: 'descriptionProduct', align: 'left', sortable: true },
        { name: 'typeMovement', label: 'Type', field: 'typeMovement', align: 'left', sortable: true },
        { name: 'sellingPrice', label: 'Selling Price', field: 'sellingPrice', align: 'left', sortable: true },
        { name: 'salesData', label: 'Sales Data', field: 'salesData', align: 'left'},
        { name: 'stockMov', label: 'Stock Movement', field: 'stockMov', align: 'left'},
      ],
      rows: [
        {
          id: 1,
          descriptionProduct: 'TV',
          typeMovement: 'In',
          sellingPrice: 250.00,
          salesData: '2025-04-22',
          stockMov: 1,
        },
      ]
    }
  },
  methods:{
    getAllMovement(){
      console.log('todas movimentacoes');
      // TODO: Metodo carrega todas Movimentacoes
    },
  },

  mounted(){
    this.getAllMovement();
  }

})
</script>
