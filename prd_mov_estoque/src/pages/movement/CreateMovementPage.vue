<template>
  <div>
    <CardCreateMovement />
  </div>
</template>

<script>
import { defineComponent } from 'vue';
import CardCreateMovement from 'src/components/movement/cards/CardCreateMovement.vue';
export default defineComponent({
  data(){
    return {
    }
  },
  components:{
    CardCreateMovement
  }
})
</script>
