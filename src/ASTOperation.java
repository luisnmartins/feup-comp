/* Generated By:JJTree: Do not edit this line. ASTOperation.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTOperation extends SimpleNode {


  public String operator = null;

  public ASTOperation(int id) {
    super(id);
  }

  public ASTOperation(parser p, int id) {
    super(p, id);
  }

  //Operation(+/-/*..)
  @Override
  public String toString(String prefix) {
    if(this.operator != null)
      return prefix + " " + toString()+ " ( "+ this.operator + " )";
    else
      return prefix + " " + toString();
  }

}
/* JavaCC - OriginalChecksum=7b2cdc49119bb66404f700b8bb760ac6 (do not edit this line) */
