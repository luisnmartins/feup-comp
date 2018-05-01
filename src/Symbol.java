
public class Symbol implements Cloneable{
    
    private Boolean isArray;
    private Integer registry;
    private Boolean isInitialized;


    public Symbol() {
        this.isArray = true;
        this.isInitialized = false;
     
    }

    public Symbol(Boolean isArray,Boolean isInitialized){
        this.isArray = isArray;
        this.isInitialized = isInitialized;

    }


    public Boolean isArray(){
        return isArray;
    }

    public void setArray(Boolean isArray){
        this.isArray = isArray;
    }

    public Boolean isInitialized(){
        return isInitialized;
    }

    public void setInitialized(Boolean initialized){
        this.isInitialized = initialized;
    }

    public void setRegistry(int registry){
        this.registry = registry;
    }

    public boolean isRegistered(){
        return this.registry != null;
    }

    /**
     * @return the registry
     */
    public Integer getRegistry() {
        return registry;
    }


    @Override
    public Symbol clone() throws CloneNotSupportedException {
        Symbol newSymbol = (Symbol)super.clone();
        newSymbol.isArray = Boolean.valueOf(isArray);
        newSymbol.isInitialized = Boolean.valueOf(isInitialized);
        if(isRegistered())
            newSymbol.registry = Integer.valueOf(registry);
        else newSymbol.registry = null;
        return newSymbol;
    }

    @Override
    public boolean equals(Object o){
        if(o == this)
            return true;
        if(!(o instanceof Symbol)){
            return false;
        }

        Symbol symbol = (Symbol) o;
        return  symbol.isInitialized().equals(this.isInitialized) && symbol.isArray().equals(this.isArray);
    }

}