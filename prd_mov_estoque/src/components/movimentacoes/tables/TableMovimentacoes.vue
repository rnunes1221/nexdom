<template>
  <div class="q-pa-md">
    <q-table
      :rows="rows"
      :columns="columns"
      row-key="name"
    >
      <template v-slot:body="props">
        <q-tr :props="props">
          <q-td key="codigo" :props="props">
            {{ props.row.codigo }}
          </q-td>

          <q-td key="descricaoProduto" :props="props">
            {{ props.row.descricaoProduto }}
          </q-td>

          <q-td key="tipoMovimentacao" :props="props">
            {{ props.row.tipoMovimentacao }}
          </q-td>

          <q-td key="valorVenda" :props="props" class="text-green">
            R$ {{ parseFloat(props.row.valorVenda).toFixed(2) }}
          </q-td>

          <q-td key="dataVenda" :props="props">
            {{ props.row.dataVenda }}
          </q-td>

          <q-td key="qtdMov" :props="props">
            {{ props.row.qtdMov }}
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
      confirmaExclusao: false,
      columns:[
        { name: 'codigo', label: 'Codigo', field: 'codigo', align: 'left', sortable: true },
        { name: 'descricaoProduto', label: 'Descrição Produto', field: 'descricaoProduto', align: 'left', sortable: true },
        { name: 'tipoMovimentacao', label: 'Tipo Mov.', field: 'tipoMovimentacao', align: 'left', sortable: true },
        { name: 'valorVenda', label: 'Valor Venda', field: 'valorVenda', align: 'left', sortable: true },
        { name: 'dataVenda', label: 'Data Venda', field: 'dataVenda', align: 'left'},
        { name: 'qtdMov', label: 'Quantidade Movimentada', field: 'qtdMov', align: 'left'},
      ],
      rows: [
        {
          codigo: 1,
          descricaoProduto: 'Televisão',
          tipoMovimentacao: 'Entrada',
          valorVenda: 250.00,
          dataVenda: '2025-04-22',
          qtdMov: 1,
        },
      ]
    }
  },
  methods:{
    getTodasMovimentacoes(){
      console.log('todas movimentacoes');
      // TODO: Metodo carrega todas Movimentacoes
    },
  },

  mounted(){
    this.getTodasMovimentacoes();
  }

})
</script>
