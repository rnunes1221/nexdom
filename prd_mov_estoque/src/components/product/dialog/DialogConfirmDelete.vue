<template>
  <q-dialog v-model="modelValue">
    <q-card>
      <q-card-section>
        <div class="text-h6">Are you sure you want to delete?</div>
      </q-card-section>

      <q-card-actions align="right">
        <q-btn flat label="Cancel" v-close-popup />
        <q-btn flat label="Confirm" color="negative" @click="confirmDelete" />
      </q-card-actions>
    </q-card>
  </q-dialog>
</template>
<script>
import { defineComponent } from 'vue';

export default defineComponent({
  props: {
    modelValue: Boolean
  },
  emits: ['update:modelValue'],

  methods: {
    confirmDelete() {
      this.$emit('update:modelValue', false)

      // TODO: Método de excluir
    }
  }
})
</script>
