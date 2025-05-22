<template>
  <div>
    <CardAdicionarMovimentacoes />
  </div>
</template>

<script>
import { defineComponent } from 'vue';
import CardAdicionarMovimentacoes from 'src/components/movimentacoes/cards/CardAdicionarMovimentacoes.vue';
export default defineComponent({
  data(){
    return {
    }
  },
  components:{
    CardAdicionarMovimentacoes
  }
})
</script>
