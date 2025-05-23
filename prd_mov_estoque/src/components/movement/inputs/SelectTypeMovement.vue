<template>
  <q-select
    :options="type"
    filled
    dense
    stack-label
    label="Type"
  />
</template>
<script>
import { defineComponent } from 'vue';

export default defineComponent({
  data(){
    return {
      type: ['In', 'Out']
    }
  },

})
</script>
