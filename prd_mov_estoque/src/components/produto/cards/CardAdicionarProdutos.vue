<template>
  <q-card>
    <q-card-section>
      <q-form @submit="adicionarProdutos(descricao, valor, tipo, quantidade)" ref="form">
        <div class="q-gutter-md">

          <div class="text-subtitle2 text-bold text-center">
            ADICIONAR PRODUTO
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
import InputProduto from '../inputs/InputProduto.vue';
import SelectTipoProduto from '../inputs/SelectTipoProduto.vue';
import { defineComponent } from 'vue';

export default defineComponent({
  data(){
    return {
      descricao: null,
      valor: 0.00,
      quantidade: 0,
      tipo: null
    }
  },
  components:{
    InputProduto,
    SelectTipoProduto
  },
  methods:{
    adicionarProdutos(descricao, valor, tipo, quantidade){
      // TODO:Método de adicionar
      console.log(descricao);
      console.log(valor);
      console.log(tipo);
      console.log(quantidade);
    }
  }
})
</script>
