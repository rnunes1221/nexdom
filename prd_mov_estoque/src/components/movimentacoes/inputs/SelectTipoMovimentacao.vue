<template>
  <q-select
    :options="tipoMovimentacao"
    filled
    dense
    stack-label
    label="Tipo Movimentação"
  />
</template>
<script>
import { defineComponent } from 'vue';

export default defineComponent({
  data(){
    return {
      tipoMovimentacao: ['Entrada', 'Saída']
    }
  },

})
</script>
