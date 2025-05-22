<template>
  <q-select
    :options="tipoProduto"
    filled
    dense
    stack-label
    label="Tipo Produto"
  />
</template>
<script>
import { defineComponent } from 'vue';

export default defineComponent({
  data(){
    return {
      tipoProduto: ['Eletrônico', 'Eletrodoméstico', 'Móvel']
    }
  },

})
</script>
