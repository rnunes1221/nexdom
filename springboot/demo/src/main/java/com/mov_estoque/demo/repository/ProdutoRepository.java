public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByTipo(TipoProduto tipo);
}