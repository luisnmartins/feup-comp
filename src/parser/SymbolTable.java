package parser;

import java.util.Stack;
import java.util.LinkedHashMap;
import java.util.AbstractMap.SimpleEntry;

/**
 * SymbolTable
 */
public abstract class SymbolTable implements Cloneable{


    LinkedHashMap<String,Symbol> variables;

    


    public SymbolTable(){
      variables = new LinkedHashMap<String,Symbol>();
    }

    public Symbol pushVariable(String name,Boolean isArray,Boolean isInitialized){

        Symbol symbol = new Symbol(isArray,isInitialized); //TODO
        variables.put(name,symbol);
        return symbol;
    }

    public Symbol pushVariable(String name, Symbol symbol) {
        variables.put(name, symbol);
        return symbol;
    }

    public GlobalTable getParent() {
        return null;
    }

    public void setReturnParameter(SimpleEntry<String,Symbol> parameter){
        
    }

    

   /* public boolean lookupAll(String name) {
        if(this.variables.containsKey(name) || this.parameters.containsKey(name))
            return true;
        else
            return false;
    }*/

    

    public Symbol lookupVariable(String lookupVariable){
       
       return this.variables.get(lookupVariable);
       
    }


    public LinkedHashMap<String,Symbol> getVariables(){
        return this.variables;
    }

    public Symbol getFromAll(String name){
        
        if(this.variables.containsKey(name)){
            return this.variables.get(name);
        }
        return null;
        
    }

    public void update(){
        return;
    }

    public Symbol getFromScope(String name){
        return this.getFromAll(name);

    }

    public Symbol hasRegistry(String name){
        if(this.variables.containsKey(name)) {
            Symbol symbol;
            if((symbol = this.variables.get(name)) != null && !symbol.isRegistered()){
                return symbol;
            }
        }
        return null;
    }

    public void print(){
        if(variables.size() == 0){
            return;
        }
            
        
        System.out.println("    Variables: ");
        for(String st: variables.keySet()){
            Symbol s = variables.get(st);
            System.out.println("        Symbol name: " + st+ " is Array? " + s.isArray() + " isInitialized? "  + s.isInitialized());
        }
    }

    public FunctionTable getFunction(String name) {
        return (FunctionTable) this;
    }

    @Override
    public SymbolTable clone() throws CloneNotSupportedException{
        SymbolTable newTable = (SymbolTable)super.clone();
        newTable.variables = (LinkedHashMap)this.variables.clone();
        return newTable;

    }


}