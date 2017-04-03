package quimica.ufc.br.estequiometria.parser;

import android.util.Log;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;

import quimica.ufc.br.estequiometria.models.Element;


/**
 * Evaluator for chemical formulas.
 * Uses the visitor pattern to visit AST nodes. Do the semantic analysis.
 * @author vladymirbezerra
 *
 */
public class Evaluator extends CompoundBaseVisitor<Double>{

	public Evaluator() {}
    public ArrayList<Element> elementsArray = new ArrayList<Element>();
	
	private ParseTree makeTree(String formula) {
		ANTLRInputStream input = new ANTLRInputStream(formula);
		CompoundLexer lexer = new CompoundLexer(input);
		lexer.removeErrorListeners();
		lexer.addErrorListener(new SyntaxErrorListener());
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CompoundParser parser = new CompoundParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(new SyntaxErrorListener());
		return parser.s();
	}
	public Double eval(String formula) {

        ParseTree tree = this.makeTree(formula);
		return this.visit(tree);
	}
	@Override 
	public Double visitS(CompoundParser.SContext ctx) {
		if(null != ctx.compound()) {
			return visit(ctx.compound());
		} else if(null != ctx.hidr()) {
			return visit(ctx.hidr());
		} else {
			return 0.0;
		}
	}
	
	@Override 
	public Double visitCompound(CompoundParser.CompoundContext ctx) {
		double value = 0.0;
		if(ctx.compound() != null) {
			//System.out.println("compound not null");
			return visit(ctx.compound()) + visit(ctx.parens());
		} else if (ctx.parens() != null) {
			return visit(ctx.parens());
		} else {
			Element ele = new Element();
            for (CompoundParser.ElementContext element : ctx.element()) {
				if(null == element) break;

                if(element.INT() == null)
                    ele = new Element(element.ATOM()+"",visit(element),1);
                else
                    ele = new Element(element.ATOM()+"",getElementMass(element),Integer.parseInt(element.INT()+""));

                value += visit(element);
			}

			elementsArray.add(ele);
			return value;
		}
	}
	
	@Override 
	public Double visitHidr(CompoundParser.HidrContext ctx) {
		return visit(ctx.compound(0)) + 
				(visit(ctx.compound(1)) *
						Double.valueOf(ctx.INT().getText()));
	}
	
	
	@Override 
	public Double visitParens(CompoundParser.ParensContext ctx) {
		return visit(ctx.compound()) * Double.valueOf(ctx.INT().getText());
	}
	
	
	@Override 
	public Double visitElement(CompoundParser.ElementContext ctx) {
		LookUpTable table = LookUpTable.getTable();
		String name = ctx.ATOM().getText();
		if(null != ctx.INT()) {
			//System.out.println(name);
			return Double.valueOf(ctx.INT().getText())
					* table.lookAtom(name);
		}
		return table.lookAtom(name); 
	}

    public Double getElementMass(CompoundParser.ElementContext ctx) {
        LookUpTable table = LookUpTable.getTable();
        String name = ctx.ATOM().getText();

        return table.lookAtom(name);
    }



}
