/**
 * Generated from platform:/resource/hu.bme.mit.sysml2autosar.queries/src/hu/bme/mit/sysml2autosar/queries/patterns.vql
 */
package hu.bme.mit.sysml2autosar.queries;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EDataTypeInSlotsKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.viatra.query.runtime.matchers.psystem.IValueProvider;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PVisibility;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * A pattern-specific query specification that can instantiate Matcher in a type-safe way.
 * 
 * <p>Original source:
 *         <code><pre>
 *         pattern clientServerInterface(umlInterface: Interface){
 *         	Interface.name(umlInterface, umlName);
 *         	check(umlName.startsWith("csi_"));
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class ClientServerInterface extends BaseGeneratedEMFQuerySpecification<ClientServerInterface.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.sysml2autosar.queries.clientServerInterface pattern,
   * to be used in conjunction with {@link Matcher}.
   * 
   * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
   * Each instance is a (possibly partial) substitution of pattern parameters,
   * usable to represent a match of the pattern in the result of a query,
   * or to specify the bound (fixed) input parameters when issuing a query.
   * 
   * @see Matcher
   * 
   */
  public static abstract class Match extends BasePatternMatch {
    private Interface fUmlInterface;

    private static List<String> parameterNames = makeImmutableList("umlInterface");

    private Match(final Interface pUmlInterface) {
      this.fUmlInterface = pUmlInterface;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "umlInterface": return this.fUmlInterface;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fUmlInterface;
          default: return null;
      }
    }

    public Interface getUmlInterface() {
      return this.fUmlInterface;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("umlInterface".equals(parameterName) ) {
          this.fUmlInterface = (Interface) newValue;
          return true;
      }
      return false;
    }

    public void setUmlInterface(final Interface pUmlInterface) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fUmlInterface = pUmlInterface;
    }

    @Override
    public String patternName() {
      return "hu.bme.mit.sysml2autosar.queries.clientServerInterface";
    }

    @Override
    public List<String> parameterNames() {
      return ClientServerInterface.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fUmlInterface};
    }

    @Override
    public ClientServerInterface.Match toImmutable() {
      return isMutable() ? newMatch(fUmlInterface) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"umlInterface\"=" + prettyPrintValue(fUmlInterface));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fUmlInterface);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof ClientServerInterface.Match)) {
          ClientServerInterface.Match other = (ClientServerInterface.Match) obj;
          return Objects.equals(fUmlInterface, other.fUmlInterface);
      } else {
          // this should be infrequent
          if (!(obj instanceof IPatternMatch)) {
              return false;
          }
          IPatternMatch otherSig  = (IPatternMatch) obj;
          return Objects.equals(specification(), otherSig.specification()) && Arrays.deepEquals(toArray(), otherSig.toArray());
      }
    }

    @Override
    public ClientServerInterface specification() {
      return ClientServerInterface.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static ClientServerInterface.Match newEmptyMatch() {
      return new Mutable(null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pUmlInterface the fixed value of pattern parameter umlInterface, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static ClientServerInterface.Match newMutableMatch(final Interface pUmlInterface) {
      return new Mutable(pUmlInterface);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pUmlInterface the fixed value of pattern parameter umlInterface, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static ClientServerInterface.Match newMatch(final Interface pUmlInterface) {
      return new Immutable(pUmlInterface);
    }

    private static final class Mutable extends ClientServerInterface.Match {
      Mutable(final Interface pUmlInterface) {
        super(pUmlInterface);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends ClientServerInterface.Match {
      Immutable(final Interface pUmlInterface) {
        super(pUmlInterface);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the hu.bme.mit.sysml2autosar.queries.clientServerInterface pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern clientServerInterface(umlInterface: Interface){
   * 	Interface.name(umlInterface, umlName);
   * 	check(umlName.startsWith("csi_"));
   * }
   * </pre></code>
   * 
   * @see Match
   * @see ClientServerInterface
   * 
   */
  public static class Matcher extends BaseMatcher<ClientServerInterface.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static ClientServerInterface.Matcher on(final ViatraQueryEngine engine) {
      // check if matcher already exists
      Matcher matcher = engine.getExistingMatcher(querySpecification());
      if (matcher == null) {
          matcher = (Matcher)engine.getMatcher(querySpecification());
      }
      return matcher;
    }

    /**
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * @return an initialized matcher
     * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
     * 
     */
    public static ClientServerInterface.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_UMLINTERFACE = 0;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ClientServerInterface.Matcher.class);

    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    private Matcher() {
      super(querySpecification());
    }

    /**
     * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pUmlInterface the fixed value of pattern parameter umlInterface, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<ClientServerInterface.Match> getAllMatches(final Interface pUmlInterface) {
      return rawStreamAllMatches(new Object[]{pUmlInterface}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pUmlInterface the fixed value of pattern parameter umlInterface, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<ClientServerInterface.Match> streamAllMatches(final Interface pUmlInterface) {
      return rawStreamAllMatches(new Object[]{pUmlInterface});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pUmlInterface the fixed value of pattern parameter umlInterface, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<ClientServerInterface.Match> getOneArbitraryMatch(final Interface pUmlInterface) {
      return rawGetOneArbitraryMatch(new Object[]{pUmlInterface});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pUmlInterface the fixed value of pattern parameter umlInterface, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Interface pUmlInterface) {
      return rawHasMatch(new Object[]{pUmlInterface});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pUmlInterface the fixed value of pattern parameter umlInterface, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Interface pUmlInterface) {
      return rawCountMatches(new Object[]{pUmlInterface});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pUmlInterface the fixed value of pattern parameter umlInterface, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Interface pUmlInterface, final Consumer<? super ClientServerInterface.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pUmlInterface}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pUmlInterface the fixed value of pattern parameter umlInterface, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public ClientServerInterface.Match newMatch(final Interface pUmlInterface) {
      return ClientServerInterface.Match.newMatch(pUmlInterface);
    }

    /**
     * Retrieve the set of values that occur in matches for umlInterface.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Interface> rawStreamAllValuesOfumlInterface(final Object[] parameters) {
      return rawStreamAllValues(POSITION_UMLINTERFACE, parameters).map(Interface.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for umlInterface.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Interface> getAllValuesOfumlInterface() {
      return rawStreamAllValuesOfumlInterface(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlInterface.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Interface> streamAllValuesOfumlInterface() {
      return rawStreamAllValuesOfumlInterface(emptyArray());
    }

    @Override
    protected ClientServerInterface.Match tupleToMatch(final Tuple t) {
      try {
          return ClientServerInterface.Match.newMatch((Interface) t.get(POSITION_UMLINTERFACE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected ClientServerInterface.Match arrayToMatch(final Object[] match) {
      try {
          return ClientServerInterface.Match.newMatch((Interface) match[POSITION_UMLINTERFACE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected ClientServerInterface.Match arrayToMatchMutable(final Object[] match) {
      try {
          return ClientServerInterface.Match.newMutableMatch((Interface) match[POSITION_UMLINTERFACE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    /**
     * @return the singleton instance of the query specification of this pattern
     * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
     * 
     */
    public static IQuerySpecification<ClientServerInterface.Matcher> querySpecification() {
      return ClientServerInterface.instance();
    }
  }

  private ClientServerInterface() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static ClientServerInterface instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected ClientServerInterface.Matcher instantiate(final ViatraQueryEngine engine) {
    return ClientServerInterface.Matcher.on(engine);
  }

  @Override
  public ClientServerInterface.Matcher instantiate() {
    return ClientServerInterface.Matcher.create();
  }

  @Override
  public ClientServerInterface.Match newEmptyMatch() {
    return ClientServerInterface.Match.newEmptyMatch();
  }

  @Override
  public ClientServerInterface.Match newMatch(final Object... parameters) {
    return ClientServerInterface.Match.newMatch((org.eclipse.uml2.uml.Interface) parameters[0]);
  }

  /**
   * Inner class allowing the singleton instance of {@link ClientServerInterface} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link ClientServerInterface#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final ClientServerInterface INSTANCE = new ClientServerInterface();

    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private static final Object STATIC_INITIALIZER = ensureInitialized();

    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternal();
      return null;
    }
  }

  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private static final ClientServerInterface.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_umlInterface = new PParameter("umlInterface", "org.eclipse.uml2.uml.Interface", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Interface")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_umlInterface);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.sysml2autosar.queries.clientServerInterface";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("umlInterface");
    }

    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }

    @Override
    public Set<PBody> doGetContainedBodies() {
      setEvaluationHints(new QueryEvaluationHint(null, QueryEvaluationHint.BackendRequirement.UNSPECIFIED));
      Set<PBody> bodies = new LinkedHashSet<>();
      {
          PBody body = new PBody(this);
          PVariable var_umlInterface = body.getOrCreateVariableByName("umlInterface");
          PVariable var_umlName = body.getOrCreateVariableByName("umlName");
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlInterface), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Interface")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_umlInterface, parameter_umlInterface)
          ));
          // 	Interface.name(umlInterface, umlName)
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlInterface), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Interface")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlInterface, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/Types", "String")));
          new Equality(body, var__virtual_0_, var_umlName);
          // 	check(umlName.startsWith("csi_"))
          new ExpressionEvaluation(body, new IExpressionEvaluator() {
          
              @Override
              public String getShortDescription() {
                  return "Expression evaluation from pattern clientServerInterface";
              }
              
              @Override
              public Iterable<String> getInputParameterNames() {
                  return Arrays.asList("umlName");}
          
              @Override
              public Object evaluateExpression(IValueProvider provider) throws Exception {
                  String umlName = (String) provider.getValue("umlName");
                  return evaluateExpression_1_1(umlName);
              }
          },  null, false);
          bodies.add(body);
      }
      return bodies;
    }
  }

  private static boolean evaluateExpression_1_1(final String umlName) {
    boolean _startsWith = umlName.startsWith("csi_");
    return _startsWith;
  }
}
