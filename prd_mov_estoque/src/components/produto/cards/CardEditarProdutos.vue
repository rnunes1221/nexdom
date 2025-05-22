<template>
  <q-card>
    <q-card-section>
      <q-form @submit="editarProduto(codigo, descricao, valor, tipo)" ref="form">
        <div class="q-gutter-md">
          <div class="text-subtitle2 text-bold text-center">
            EDITAR PRODUTO
          </div>

          <InputProduto
            label="descricao"
            v-model="descricao"
            :rules="[val => !!val || 'Descrição é obrigatória']"
          />

          <InputProduto
            label="valor"
            v-model="valor"
            type="number"
            :rules="[
              val => !!val || 'Valor é obrigatório',
              val => parseFloat(val) > 0 || 'Valor deve ser maior que 0'
            ]"
          />

          <SelectTipoProduto
            v-model="tipo"
            :rules="[val => !!val || 'Tipo é obrigatório']"
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
import InputProduto from '../inputs/InputProduto.vue';
import SelectTipoProduto from '../inputs/SelectTipoProduto.vue';
import { defineComponent } from 'vue';

export default defineComponent({
  data(){
    return {
      descricao: null,
      valor: null,
      tipo:null,
      codigo: null
    }
  },
  components:{
    InputProduto,
    SelectTipoProduto
  },
  methods:{
    editarProduto(codigo, descricao, valor, tipo){

      // TODO:Método de Editar Produto
      console.log(codigo);
      console.log(descricao);
      console.log(parseFloat(valor).toFixed(2));
      console.log(tipo);
    },

    inicializaVariaveis(produtoRouteParams){
      this.codigo = produtoRouteParams.codigo;
      this.descricao = produtoRouteParams.descricao;
      this.valor = parseFloat(produtoRouteParams.valorFornecedor).toFixed(2);
      this.tipo = produtoRouteParams.tipo;
    }
  },
  mounted(){
    const produtoRouteParams = JSON.parse(this.$route.query.produto);
    this.inicializaVariaveis(produtoRouteParams)
  }
})
</script>
