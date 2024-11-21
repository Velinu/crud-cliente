import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    private ArrayList<Cliente> clientes = new ArrayList<>();
        private Scanner scanner = new Scanner(System.in);
    
        public void menu() {
            while (true) {
                System.out.println("\n--- Menu ---");
                System.out.println("1. Adicionar Cliente");
                System.out.println("2. Listar Clientes");
                System.out.println("3. Atualizar Cliente");
                System.out.println("4. Remover Cliente");
                System.out.println("5. Buscar Cliente");
                System.out.println("6. Sair");
                System.out.print("Digite uma opção: ");
    
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a nova linha
    
                switch (opcao) {
                    case 1 -> cadastrarCliente();
                    case 2 -> listarClientes();
                    case 3 -> atualizarCliente();
                    case 4 -> removerCliente();
                    case 5 -> buscarCliente();
                    case 6 -> {
                        System.out.println("Saindo...");
                        return;
                    }
                    default -> System.out.println("Opção inválida!");
                }
            }
        }
    
        private void cadastrarCliente() {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
    
            clientes.add(new Cliente(id, nome, email, telefone));
            System.out.println("Cliente cadastrado com sucesso!");
        }
    
        private void listarClientes() {
            if (clientes.isEmpty()) {
                System.out.println("Nenhum cliente cadastrado.");
            } else {
                System.out.println("--- Lista de Clientes ---");
                clientes.forEach((cliente) -> 
                System.out.println("ID: " + cliente.getId() + 
                ", Nome: " + cliente.getNome() + 
                ", Email: " + cliente.getEmail() + 
                ", Telefone: " + cliente.getTelefone() + "\n"));
            }
        }
    
        private void atualizarCliente() {
            System.out.print("ID do cliente a ser atualizado: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha
    
            Cliente cliente = buscarClientePorId(id);
            if (cliente != null) {
                System.out.print("Novo nome (atual: " + cliente.getNome() + "): ");
                cliente.setNome(scanner.nextLine());
                System.out.print("Novo email (atual: " + cliente.getEmail() + "): ");
                cliente.setEmail(scanner.nextLine());
                System.out.print("Novo telefone (atual: " + cliente.getTelefone() + "): ");
                cliente.setTelefone(scanner.nextLine());
                System.out.println("Cliente atualizado com sucesso!");
            } else {
                System.out.println("Cliente não encontrado.");
            }
        }
    
        private void removerCliente() {
            System.out.print("ID do cliente a ser removido: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha
    
            Cliente cliente = buscarClientePorId(id);
            if (cliente != null) {
                clientes.remove(cliente);
                System.out.println("Cliente removido com sucesso!");
            } else {
                System.out.println("Cliente não encontrado.");
            }
        }
    
        private void buscarCliente() {
            System.out.print("ID do cliente: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha
    
            Cliente cliente = buscarClientePorId(id);
            if (cliente != null) {
                System.out.println(
                    "ID: " + cliente.getId() + 
                    ", Nome: " + cliente.getNome() + 
                    ", Email: " + cliente.getEmail() + 
                    ", Telefone: " + cliente.getTelefone() +
                    "\n"
                );
            } else {
                System.out.println("Cliente não encontrado.");
            }
        }
    
        private Cliente buscarClientePorId(int id) {
            for (Cliente cliente : clientes) {
                if (cliente.getId() == id) {
                    return cliente;
                }
            }
            return null;
        }
    }
    