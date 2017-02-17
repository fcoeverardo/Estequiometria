// Generated from Compound.g4 by ANTLR 4.3

 package quimica.ufc.br.estequiometria.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CompoundParser}.
 */
public interface CompoundListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CompoundParser#parens}.
	 * @param ctx the parse tree
	 */
	void enterParens(CompoundParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompoundParser#parens}.
	 * @param ctx the parse tree
	 */
	void exitParens(CompoundParser.ParensContext ctx);

	/**
	 * Enter a parse tree produced by {@link CompoundParser#s}.
	 * @param ctx the parse tree
	 */
	void enterS(CompoundParser.SContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompoundParser#s}.
	 * @param ctx the parse tree
	 */
	void exitS(CompoundParser.SContext ctx);

	/**
	 * Enter a parse tree produced by {@link CompoundParser#compound}.
	 * @param ctx the parse tree
	 */
	void enterCompound(CompoundParser.CompoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompoundParser#compound}.
	 * @param ctx the parse tree
	 */
	void exitCompound(CompoundParser.CompoundContext ctx);

	/**
	 * Enter a parse tree produced by {@link CompoundParser#hidr}.
	 * @param ctx the parse tree
	 */
	void enterHidr(CompoundParser.HidrContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompoundParser#hidr}.
	 * @param ctx the parse tree
	 */
	void exitHidr(CompoundParser.HidrContext ctx);

	/**
	 * Enter a parse tree produced by {@link CompoundParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(CompoundParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CompoundParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(CompoundParser.ElementContext ctx);
}