<template>
  <div class="q-pa-md">
    <q-table
      title="Produtos"
      :rows="rows"
      :columns="columns"
      row-key="name"
    >
      <template v-slot:top-left>
        <q-btn
          label="Produto"
          icon="add"
          color="primary"
          dense
          @click="redirectAdicionarProdutosPage()"
        />
      </template>

      <template v-slot:body="props">
        <q-tr :props="props">
          <q-td key="codigo" :props="props">
            {{ props.row.codigo }}
          </q-td>

          <q-td key="descricao" :props="props">
            {{ props.row.descricao }}
          </q-td>

          <q-td key="tipo" :props="props">
            {{ props.row.tipo }}
          </q-td>

          <q-td key="valorFornecedor" :props="props" class="text-green">
            R$ {{ parseFloat(props.row.valorFornecedor).toFixed(2) }}
          </q-td>

          <q-td key="quantidade" :props="props">
            {{ props.row.quantidade }}
          </q-td>

          <q-td key="operacoes" :props="props">
             <q-btn
              icon="reorder"
              round
              dense
              size="11px"
              color="primary"
              @click="redirectAdicionarMovimentacoesPage(props.row)"
            >
              <q-tooltip>
                Criar movimentações
              </q-tooltip>
            </q-btn>
            <q-btn
              icon="edit"
              round
              dense
              size="11px"
              color="primary"
              class="q-ml-sm"
              @click="redirectEditarProdutosPage(props.row)"
            >
              <q-tooltip>
                Editar
              </q-tooltip>
            </q-btn>

            <q-btn
              icon="delete"
              round
              dense
              size="11px"
              color="negative"
              class="q-ml-sm"
              @click="confirmaExclusao = true"
            >
              <q-tooltip>
                Excluir
              </q-tooltip>
            </q-btn>
          </q-td>
        </q-tr>
      </template>
    </q-table>
  </div>
  <DialogConfirmaExclusao v-model="confirmaExclusao"/>

</template>
<script>
import { defineComponent } from 'vue';
import DialogConfirmaExclusao from '../dialog/DialogConfirmaExclusao.vue';
export default defineComponent({
  data(){
    return {
      confirmaExclusao: false,
      columns:[
        { name: 'codigo', label: 'Codigo', field: 'codigo', align: 'left', sortable: true },
        { name: 'descricao', label: 'Descrição', field: 'descricao', align: 'left', sortable: true },
        { name: 'tipo', label: 'Tipo', field: 'tipo', align: 'left', sortable: true },
        { name: 'valorFornecedor', label: 'Valor', field: 'valorFornecedor', align: 'left', sortable: true },
        { name: 'quantidade', label: 'Quantidade', field: 'quantidade', align: 'left', sortable: true },
        { name: 'operacoes', label: 'Operações', field: 'operacoes', align: 'left'},
      ],
      rows: [
        {
          codigo: 1,
          descricao: 'Televisão',
          tipo: 'Eletrodoméstico',
          valorFornecedor: 240.00,
          quantidade: 10,
        },
      ]
    }
  },
  methods:{
    redirectAdicionarProdutosPage(){
      this.$router.push({ path: 'adicionarProdutos'});
    },

    redirectEditarProdutosPage(produto){
      this.$router.push({
        path: 'editarProdutos',
        query: { produto: JSON.stringify(produto) }
      });
    },

    redirectAdicionarMovimentacoesPage(produto){
      this.$router.push({
        path: 'adicionarMovimentacoes',
        query: { produto: JSON.stringify(produto) }
      });
    },

    getTodosProdutos(){
      console.log('todos produtos');
      // TODO: Metodo carrega todos os produtos
    }
  },
  components:{
    DialogConfirmaExclusao
  },
  mounted(){
    this.getTodosProdutos();
  }

})
</script>
