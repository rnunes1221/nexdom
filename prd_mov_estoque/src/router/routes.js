const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('src/pages/produtos/ProdutosPage.vue') },
      { path: 'adicionarProdutos', component: () => import('src/pages/produtos/AdicionarProdutosPage.vue') },
      { path: 'editarProdutos', component: () => import('src/pages/produtos/EditarProdutosPage.vue') }
    ]
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue')
  }
]

export default routes
