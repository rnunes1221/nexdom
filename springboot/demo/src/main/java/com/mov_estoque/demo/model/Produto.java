@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private TipoProduto tipo;

    private Double valorFornecedor;
    private Integer quantidadeEstoque;
}
