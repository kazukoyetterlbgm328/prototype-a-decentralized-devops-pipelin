import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecentralizedDevOpsPipelineAnalyzer {

    // Node representation in the pipeline
    class Node {
        String id;
        String type; // e.g., "git", "jenkins", "kubernetes"
        List<Node> dependencies = new ArrayList<>();

        public Node(String id, String type) {
            this.id = id;
            this.type = type;
        }

        public void addDependency(Node node) {
            dependencies.add(node);
        }
    }

    // Decentralized pipeline representation
    class Pipeline {
        List<Node> nodes = new ArrayList<>();
        Map<String, Node> nodesMap = new HashMap<>();

        public void addNode(Node node) {
            nodes.add(node);
            nodesMap.put(node.id, node);
        }

        public Node getNodeById(String id) {
            return nodesMap.get(id);
        }
    }

    public static void main(String[] args) {
        DecentralizedDevOpsPipelineAnalyzer analyzer = new DecentralizedDevOpsPipelineAnalyzer();
        Pipeline pipeline = analyzer.new Pipeline();

        // Create nodes
        Node gitNode = analyzer.new Node("git-1", "git");
        Node jenkinsNode = analyzer.new Node("jenkins-1", "jenkins");
        Node kubernetesNode = analyzer.new Node("kubernetes-1", "kubernetes");

        // Create dependencies
        jenkinsNode.addDependency(gitNode);
        kubernetesNode.addDependency(jenkinsNode);

        // Add nodes to pipeline
        pipeline.addNode(gitNode);
        pipeline.addNode(jenkinsNode);
        pipeline.addNode(kubernetesNode);

        // Analyze pipeline
        analyzer.analyzePipeline(pipeline);
    }

    public void analyzePipeline(Pipeline pipeline) {
        System.out.println("Analyzing pipeline...");
        for (Node node : pipeline.nodes) {
            System.out.println("Node: " + node.id + " (" + node.type + ")");
            if (!node.dependencies.isEmpty()) {
                System.out.println("  Depends on:");
                for (Node dependency : node.dependencies) {
                    System.out.println("    " + dependency.id + " (" + dependency.type + ")");
                }
            }
        }
    }
}