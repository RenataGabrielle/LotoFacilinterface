# Jogo Loteria GUI

Este projeto é uma aplicação gráfica em Java que simula um jogo de loteria simples, permitindo ao usuário apostar em números, letras ou par/impar. A interface gráfica é construída usando a biblioteca Swing.

## Estrutura do Código

### Classes e Componentes

1. **JogoLoteriaGUI**: Classe principal que estende `JFrame` e implementa `ActionListener`.
   - **Componentes da Interface:**
     - `JButton btnApostarNumero`: Botão para apostar em um número entre 0 e 100.
     - `JButton btnApostarLetra`: Botão para apostar em uma letra de A a Z.
     - `JButton btnApostarParImpar`: Botão para apostar se um número é par ou ímpar.
     - `JButton btnSair`: Botão para sair do jogo.

2. **Construtor `JogoLoteriaGUI`**: Inicializa a janela da aplicação, configura o título, tamanho, e adiciona os botões à interface.

3. **Método `actionPerformed(ActionEvent e)`**: Trata as ações dos botões:
   - Aposta em número: O usuário insere um número e a aplicação gera um número aleatório. Se corresponder, o usuário ganha R$ 1.000,00.
   - Aposta em letra: O usuário insere uma letra e verifica se é igual à letra premiada ('R'). Se sim, o usuário ganha R$ 500,00.
   - Aposta em par ou ímpar: O usuário insere um número e se for par, ele ganha R$ 100,00.
   - Botão sair: Exibe uma mensagem e fecha a aplicação.

4. **Método `main(String[] args)`**: Ponto de entrada do programa que cria uma nova instância da classe `JogoLoteriaGUI`.

## Funcionalidade

Quando a aplicação é executada, uma janela é exibida com quatro botões. O usuário pode interagir com os botões para fazer suas apostas. A aplicação utiliza diálogos para entrada e saída de informações.

## Melhorias Sugeridas

1. **Validação de Entrada**:
   - Adicionar verificações para entradas do usuário, como garantir que o número apostado está no intervalo correto ou que a letra está no formato correto.

2. **Números Aleatórios**:
   - Para a aposta de letra, em vez de ter uma letra fixa ('R'), poderia haver uma seleção aleatória de letras para tornar o jogo mais interessante.

3. **Feedback para o Usuário**:
   - Informar ao usuário sobre regras adicionais do jogo ou sobre como as apostas funcionam.

4. **Estilo da Interface**:
   - Personalizar a interface com cores e fontes para torná-la mais atraente.

5. **Sistema de Pontuação**:
   - Implementar um sistema de pontuação que acumule as vitórias e derrote ao longo do tempo.

### Código com Validações

Aqui está uma versão melhorada do método `actionPerformed`, incluindo algumas validações básicas:

```java
public void actionPerformed(ActionEvent e) {
    Random random = new Random();
    if (e.getSource() == btnApostarNumero) {
        String input = JOptionPane.showInputDialog("Digite um número de 0 a 100: ");
        try {
            int numeroAposta = Integer.parseInt(input);
            if (numeroAposta < 0 || numeroAposta > 100) {
                JOptionPane.showMessageDialog(this, "Número inválido! Digite um número entre 0 e 100.");
                return;
            }
            int numeroSorteado = random.nextInt(101);
            if (numeroAposta == numeroSorteado) {
                JOptionPane.showMessageDialog(this, "Você ganhou R$ 1.000,00 reais.");
            } else {
                JOptionPane.showMessageDialog(this, "Que pena! O número sorteado foi: " + numeroSorteado + ".");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Entrada inválida! Por favor, insira um número.");
        }
    } else if (e.getSource() == btnApostarLetra) {
        String entrada = JOptionPane.showInputDialog("Digite uma letra de A à Z: ");
        if (entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
            JOptionPane.showMessageDialog(this, "Entrada inválida! Digite apenas uma letra.");
            return;
        }
        char letraAposta = Character.toUpperCase(entrada.charAt(0));
        char letraPremiada = 'R'; 
        if (letraAposta == letraPremiada) {
            JOptionPane.showMessageDialog(this, "Você ganhou R$ 500,00 reais.");
        } else {
            JOptionPane.showMessageDialog(this, "Que pena! A letra sorteada foi: " + letraPremiada + ".");
        }
    } else if (e.getSource() == btnApostarParImpar) {
        String input = JOptionPane.showInputDialog("Digite um número inteiro: ");
        try {
            int numero = Integer.parseInt(input);
            if (numero % 2 == 0) {
                JOptionPane.showMessageDialog(this, "Você ganhou R$ 100,00 reais.");
            } else {
                JOptionPane.showMessageDialog(this, "Que pena! O número digitado é ímpar e a premiação foi para números pares.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Entrada inválida! Por favor, insira um número.");
        }
    } else if (e.getSource() == btnSair) {
        JOptionPane.showMessageDialog(this, "Saindo...");
        System.exit(0);
    }
}
