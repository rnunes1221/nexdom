<template>
  <q-card>
    <q-card-section>
      <q-form @submit="adicionarProdutos(produto, valorVenda, tipo, quantidade)" ref="form">
        <div class="q-gutter-md">

          <div class="text-subtitle2 text-bold text-center">
            ADICIONAR MOVIMENTACAO
          </div>

          <InputProduto
            label="produto"
            v-model="produto"
            :rules="[val => !!val || 'Produto é obrigatória']"
            disable
          />

          <SelectTipoMovimentacao
            v-model="tipo"
            :rules="[val => !!val || 'Tipo é obrigatório']"
          />

          <div class="text-grey caption q-mt-none q-pt-none">
            Valor Fornecedor: {{ parseFloat(this.valorFornecedor).toFixed(2) }}
          </div>
          <InputProduto
            label="valorVenda"
            v-model="valorVenda"
            type="number"
            :rules="[
              val => !!val || 'Valor é obrigatório',
              val => parseFloat(val) > 0 || 'Valor deve ser maior que 0'
            ]"
          />

          <InputProduto
            label="quantidade"
            v-model="quantidade"
            type="number"
            :rules="[
              val => !!val || 'Valor é obrigatório',
              val => parseFloat(val) > 0 || 'Valor deve ser maior que 0'
            ]"
          />

          <div>
            <q-btn
              class="full-width text-bold"
              label="Salvar"
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
import InputProduto from 'src/components/produto/inputs/InputProduto.vue';
import SelectTipoMovimentacao from '../inputs/SelectTipoMovimentacao.vue';
import { defineComponent } from 'vue';

export default defineComponent({
  data(){
    return {
      idProduto: null,
      produto: null,
      valorVenda: 0.00,
      quantidade: 0,
      tipo: null,
      valorFornecedor: 0,
    }
  },
  components:{
    InputProduto,
    SelectTipoMovimentacao
  },
  methods:{
    adicionarMovimentacoes(produto, valorVenda, tipo, quantidade){
      // TODO:Método de adicionar
      console.log(produto);
      console.log(valor);
      console.log(tipo);
      console.log(quantidade);
    },

    inicializaVariaveis(produtoRouteParams){
      this.produto = produtoRouteParams.descricao;
      this.idProduto = produtoRouteParams.codigo;
      this.valorFornecedor = produtoRouteParams.valorFornecedor;
    }
  },
  mounted(){
    const produtoRouteParams = JSON.parse(this.$route.query.produto);
    this.inicializaVariaveis(produtoRouteParams)
  }
})
</script>
<style>
.caption{
  font-size: 10px;
}
</style>
