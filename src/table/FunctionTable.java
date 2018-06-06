package table;
import java.util.LinkedHashMap;
import java.util.AbstractMap.SimpleEntry;



public class FunctionTable extends SymbolTable {

    private LinkedHashMap<String,Symbol> parameters;
    private SimpleEntry<String,Symbol> returnParameter = null;
    private GlobalTable parent;
    int maxRegistry = 0;
    Boolean isClone = false;
    Boolean retHasReg = false;
    

    public FunctionTable(GlobalTable parent) {
        super();
        parameters = new LinkedHashMap<>();
        this.parent = parent;
    }

    public Symbol getFromAll(String name){
        if(this.variables.containsKey(name)){
            return this.variables.get(name);
        }else if(this.parameters.containsKey(name)){
            return this.parameters.get(name);
        } else if(this.returnParameter != null  && returnParameter.getKey().equals(name)){
            return this.returnParameter.getValue();
        }else{
            return this.parent.getFromAll(name);
        }
        
    }


    public Symbol getFromScope(String name){
        if(this.variables.containsKey(name)){
            return this.variables.get(name);
        }else if(this.parameters.containsKey(name)){
            return this.parameters.get(name);
        }else if(this.returnParameter != null  && returnParameter.getKey().equals(name)){
            return this.returnParameter.getValue();
            
        }
        return null;
    }


    public Symbol pushParameter(String name,Boolean isArray,Boolean isInitialized){

        Symbol symbol = new Symbol(isArray,isInitialized); //TODO
        parameters.put(name,symbol);
        return symbol;
    }

    public void setReturnParameter(String name,Boolean isArray,Boolean isInitialized){
        
        this.returnParameter = new SimpleEntry<>(name,new Symbol(isArray,isInitialized));
    }

    public void setReturnParameter(SimpleEntry<String,Symbol> parameter){
        this.returnParameter = parameter;
    }

    /**
     * @return the returnParameter
     */
    public SimpleEntry<String,Symbol> getReturnParameter() {
        if(returnParameter != null)
            return returnParameter;
        else
            return null;
    }

    public Symbol lookupParameters(String lookupParameter){
        
        return this.parameters.get(lookupParameter);
         
     }
 
     public LinkedHashMap<String,Symbol> getParameters()
     {
         return this.parameters;
     }

     public void print(){
        if(parameters.size() != 0) {
            System.out.println("    Parameters: ");
            for(String st: parameters.keySet()){
                Symbol s = parameters.get(st);
            System.out.println("        Symbol name: " + st + " is Array? " + s.isArray() + " isInitialized? "  + s.isInitialized());
            }
        }
        super.print();
        if(returnParameter != null){
            System.out.println("    Return: ");
            System.out.println("        Symbol name: " + returnParameter.getKey() + " is Array? " + returnParameter.getValue().isArray() + " isInitialized? "  + returnParameter.getValue().isInitialized());
        }
    }

    public FunctionTable getFunction(String name) {
        return parent.getFunction(name);
    }

    @Override
    public FunctionTable clone() throws CloneNotSupportedException{
        FunctionTable newTable = (FunctionTable)super.clone();
        newTable.parameters = (LinkedHashMap) parameters.clone();
        if(returnParameter != null)
            newTable.returnParameter = new SimpleEntry<>(new String(returnParameter.getKey()), returnParameter.getValue().clone());
        newTable.parent = (GlobalTable)parent.clone();
        return newTable;

    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(LinkedHashMap<String, Symbol> parameters) {
        this.parameters = parameters;
    }

    public void setParent(GlobalTable table) {
        this.parent = table;
    }

    

    public GlobalTable getParent() {
        return this.parent;
    }

    public void setMaxRegistry(int maxRegistry) {
        this.maxRegistry = maxRegistry;
    }

    public int getMaxRegistry() {
        return maxRegistry;
    }

    public void setisClone(Boolean isClone) {
        this.isClone = isClone;
    }

    public Boolean getisClone() {
        return isClone;
    }

    public void setRetHasReg(Boolean retHasReg) {
        this.retHasReg = retHasReg;
    }

    public Boolean getRetHasReg() {
        return retHasReg;
    }

}