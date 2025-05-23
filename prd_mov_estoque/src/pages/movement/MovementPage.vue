<template>
  <div>
    <TableMovement />
  </div>
</template>

<script>
import { defineComponent } from 'vue';
import TableMovement from 'src/components/movement/tables/TableMovement.vue';
export default defineComponent({
  data(){
    return {
    }
  },
  components:{
    TableMovement
  }
})
</script>
