public class Edge implements Comparable<Edge> {

    private Process process;
    private Resource resource;
    private int weight;

    public Edge(Process process, Resource resource){
        this(process, resource, 1);
    }
    
    public Edge(Process process, Resource resource, int weight){
        this.process = process;
        this.resource = resource;
        this.weight = weight;
    }
    
//    public Process getResource(Process current){
//        if(!(current.equals(one) || current.equals(two))){
//            return null;
//        }
//        
//        return (current.equals(one)) ? two : one;
//    }
    
    public Process getProcess(){
        return this.process;
    }
    
    public Resource getResource(){
        return this.resource;
    }
    
  
    public int getWeight(){
        return this.weight;
    }
    

    public void setWeight(int weight){
        this.weight = weight;
    }
    

    public int compareTo(Edge other){
        return this.weight - other.weight;
    }
    

    public String toString(){
        return "({" + process + ", " + resource + "}, " + weight + ")";
    }
    

    public int hashCode(){
        return (process.getLabel() + resource.getLabel()).hashCode(); 
    }
    

    public boolean equals(Object other){
        if(!(other instanceof Edge)){
            return false;
        }
        
        Edge e = (Edge)other;
        
        return e.process.equals(this.process) && e.resource.equals(this.resource);
    }   
}