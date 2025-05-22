<template>
  <div>
    <TableMovimentacoes />
  </div>
</template>

<script>
import { defineComponent } from 'vue';
import TableMovimentacoes from 'src/components/movimentacoes/tables/TableMovimentacoes.vue';
export default defineComponent({
  data(){
    return {
    }
  },
  components:{
    TableMovimentacoes
  }
})
</script>
