// Generated from Compound.g4 by ANTLR 4.3

 package quimica.ufc.br.estequiometria.parser;



// Generated from Compound.g4 by ANTLR 4.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CompoundParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
			new PredictionContextCache();
	public static final int
			T__2=1, T__1=2, T__0=3, ATOM=4, INT=5, N=6, WS=7;
	public static final String[] tokenNames = {
			"<INVALID>", "'('", "')'", "'.'", "ATOM", "INT", "N", "WS"
	};
	public static final int
			RULE_s = 0, RULE_compound = 1, RULE_hidr = 2, RULE_parens = 3, RULE_element = 4;
	public static final String[] ruleNames = {
			"s", "compound", "hidr", "parens", "element"
	};

	@Override
	public String getGrammarFileName() { return "Compound.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CompoundParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SContext extends ParserRuleContext {
		public HidrContext hidr() {
			return getRuleContext(HidrContext.class,0);
		}
		public CompoundContext compound() {
			return getRuleContext(CompoundContext.class,0);
		}
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompoundListener ) ((CompoundListener)listener).enterS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompoundListener ) ((CompoundListener)listener).exitS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompoundVisitor ) return ((CompoundVisitor<? extends T>)visitor).visitS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_s);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(12);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
					{
						setState(10); compound(0);
					}
					break;

					case 2:
					{
						setState(11); hidr();
					}
					break;
				}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompoundContext extends ParserRuleContext {
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public ParensContext parens() {
			return getRuleContext(ParensContext.class,0);
		}
		public CompoundContext compound() {
			return getRuleContext(CompoundContext.class,0);
		}
		public CompoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompoundListener ) ((CompoundListener)listener).enterCompound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompoundListener ) ((CompoundListener)listener).exitCompound(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompoundVisitor ) return ((CompoundVisitor<? extends T>)visitor).visitCompound(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundContext compound() throws RecognitionException {
		return compound(0);
	}

	private CompoundContext compound(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CompoundContext _localctx = new CompoundContext(_ctx, _parentState);
		CompoundContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_compound, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				setState(23);
				switch (_input.LA(1)) {
					case ATOM:
					{
						setState(15); element();
						{
							setState(19);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
										{
											setState(16); element();
										}
									}
								}
								setState(21);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
							}
						}
					}
					break;
					case T__2:
					{
						setState(22); parens();
					}
					break;
					default:
						throw new NoViableAltException(this);
				}
				_ctx.stop = _input.LT(-1);
				setState(29);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						if ( _parseListeners!=null ) triggerExitRuleEvent();
						_prevctx = _localctx;
						{
							{
								_localctx = new CompoundContext(_parentctx, _parentState);
								pushNewRecursionContext(_localctx, _startState, RULE_compound);
								setState(25);
								if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
								setState(26); parens();
							}
						}
					}
					setState(31);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class HidrContext extends ParserRuleContext {
		public List<CompoundContext> compound() {
			return getRuleContexts(CompoundContext.class);
		}
		public CompoundContext compound(int i) {
			return getRuleContext(CompoundContext.class,i);
		}
		public TerminalNode INT() { return getToken(CompoundParser.INT, 0); }
		public HidrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hidr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompoundListener ) ((CompoundListener)listener).enterHidr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompoundListener ) ((CompoundListener)listener).exitHidr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompoundVisitor ) return ((CompoundVisitor<? extends T>)visitor).visitHidr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HidrContext hidr() throws RecognitionException {
		HidrContext _localctx = new HidrContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_hidr);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(32); compound(0);
				setState(33); match(T__0);
				setState(34); match(INT);
				setState(35); compound(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParensContext extends ParserRuleContext {
		public CompoundContext compound() {
			return getRuleContext(CompoundContext.class,0);
		}
		public TerminalNode INT() { return getToken(CompoundParser.INT, 0); }
		public ParensContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parens; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompoundListener ) ((CompoundListener)listener).enterParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompoundListener ) ((CompoundListener)listener).exitParens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompoundVisitor ) return ((CompoundVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParensContext parens() throws RecognitionException {
		ParensContext _localctx = new ParensContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parens);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(37); match(T__2);
				setState(38); compound(0);
				setState(39); match(T__1);
				setState(40); match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElementContext extends ParserRuleContext {
		public TerminalNode ATOM() { return getToken(CompoundParser.ATOM, 0); }
		public TerminalNode INT() { return getToken(CompoundParser.INT, 0); }
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CompoundListener ) ((CompoundListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CompoundListener ) ((CompoundListener)listener).exitElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CompoundVisitor ) return ((CompoundVisitor<? extends T>)visitor).visitElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_element);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(42); match(ATOM);
				setState(44);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
					{
						setState(43); match(INT);
					}
					break;
				}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
			case 1: return compound_sempred((CompoundContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean compound_sempred(CompoundContext _localctx, int predIndex) {
		switch (predIndex) {
			case 0: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
			"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\t\61\4\2\t\2\4\3"+
					"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\5\2\17\n\2\3\3\3\3\3\3\7\3\24\n\3"+
					"\f\3\16\3\27\13\3\3\3\5\3\32\n\3\3\3\3\3\7\3\36\n\3\f\3\16\3!\13\3\3\4"+
					"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\5\6/\n\6\3\6\2\3\4\7\2\4"+
					"\6\b\n\2\2\60\2\16\3\2\2\2\4\31\3\2\2\2\6\"\3\2\2\2\b\'\3\2\2\2\n,\3\2"+
					"\2\2\f\17\5\4\3\2\r\17\5\6\4\2\16\f\3\2\2\2\16\r\3\2\2\2\17\3\3\2\2\2"+
					"\20\21\b\3\1\2\21\25\5\n\6\2\22\24\5\n\6\2\23\22\3\2\2\2\24\27\3\2\2\2"+
					"\25\23\3\2\2\2\25\26\3\2\2\2\26\32\3\2\2\2\27\25\3\2\2\2\30\32\5\b\5\2"+
					"\31\20\3\2\2\2\31\30\3\2\2\2\32\37\3\2\2\2\33\34\f\4\2\2\34\36\5\b\5\2"+
					"\35\33\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \5\3\2\2\2!\37\3"+
					"\2\2\2\"#\5\4\3\2#$\7\5\2\2$%\7\7\2\2%&\5\4\3\2&\7\3\2\2\2\'(\7\3\2\2"+
					"()\5\4\3\2)*\7\4\2\2*+\7\7\2\2+\t\3\2\2\2,.\7\6\2\2-/\7\7\2\2.-\3\2\2"+
					"\2./\3\2\2\2/\13\3\2\2\2\7\16\25\31\37.";
	public static final ATN _ATN =
			new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}