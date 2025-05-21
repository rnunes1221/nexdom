public interface MovimentoEstoqueRepository extends JpaRepository<MovimentoEstoque, Long> {
    List<MovimentoEstoque> findByProdutoIdAndTipo(Long produtoId, TipoMovimentacao tipo);
}