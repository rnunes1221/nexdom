<template>
  <q-dialog v-model="modelValue">
    <q-card>
      <q-card-section>
        <div class="text-h6">Tem certeza que deseja excluir?</div>
      </q-card-section>

      <q-card-actions align="right">
        <q-btn flat label="Cancelar" v-close-popup />
        <q-btn flat label="Confirmar" color="negative" @click="confirmarExclusao" />
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
    confirmarExclusao() {
      this.$emit('update:modelValue', false)

      // TODO: Método de excluir
    }
  }
})
</script>
