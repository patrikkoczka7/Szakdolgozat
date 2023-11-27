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
 *         pattern sriVariableDataPrototype(umlClass: UML::Class){
 *         	InterfaceBlock.base_Class(_, umlClass);
 *         	Class.ownedAttribute(umlClass, _);
 *         	Class.ownedAttribute.name(umlClass, umlName);
 *         	check(umlName.startsWith("vdp_"));
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class SriVariableDataPrototype extends BaseGeneratedEMFQuerySpecification<SriVariableDataPrototype.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.sysml2autosar.queries.sriVariableDataPrototype pattern,
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
    private org.eclipse.uml2.uml.Class fUmlClass;

    private static List<String> parameterNames = makeImmutableList("umlClass");

    private Match(final org.eclipse.uml2.uml.Class pUmlClass) {
      this.fUmlClass = pUmlClass;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "umlClass": return this.fUmlClass;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fUmlClass;
          default: return null;
      }
    }

    public org.eclipse.uml2.uml.Class getUmlClass() {
      return this.fUmlClass;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("umlClass".equals(parameterName) ) {
          this.fUmlClass = (org.eclipse.uml2.uml.Class) newValue;
          return true;
      }
      return false;
    }

    public void setUmlClass(final org.eclipse.uml2.uml.Class pUmlClass) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fUmlClass = pUmlClass;
    }

    @Override
    public String patternName() {
      return "hu.bme.mit.sysml2autosar.queries.sriVariableDataPrototype";
    }

    @Override
    public List<String> parameterNames() {
      return SriVariableDataPrototype.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fUmlClass};
    }

    @Override
    public SriVariableDataPrototype.Match toImmutable() {
      return isMutable() ? newMatch(fUmlClass) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"umlClass\"=" + prettyPrintValue(fUmlClass));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fUmlClass);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof SriVariableDataPrototype.Match)) {
          SriVariableDataPrototype.Match other = (SriVariableDataPrototype.Match) obj;
          return Objects.equals(fUmlClass, other.fUmlClass);
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
    public SriVariableDataPrototype specification() {
      return SriVariableDataPrototype.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static SriVariableDataPrototype.Match newEmptyMatch() {
      return new Mutable(null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static SriVariableDataPrototype.Match newMutableMatch(final org.eclipse.uml2.uml.Class pUmlClass) {
      return new Mutable(pUmlClass);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static SriVariableDataPrototype.Match newMatch(final org.eclipse.uml2.uml.Class pUmlClass) {
      return new Immutable(pUmlClass);
    }

    private static final class Mutable extends SriVariableDataPrototype.Match {
      Mutable(final org.eclipse.uml2.uml.Class pUmlClass) {
        super(pUmlClass);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends SriVariableDataPrototype.Match {
      Immutable(final org.eclipse.uml2.uml.Class pUmlClass) {
        super(pUmlClass);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the hu.bme.mit.sysml2autosar.queries.sriVariableDataPrototype pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern sriVariableDataPrototype(umlClass: UML::Class){
   * 	InterfaceBlock.base_Class(_, umlClass);
   * 	Class.ownedAttribute(umlClass, _);
   * 	Class.ownedAttribute.name(umlClass, umlName);
   * 	check(umlName.startsWith("vdp_"));
   * }
   * </pre></code>
   * 
   * @see Match
   * @see SriVariableDataPrototype
   * 
   */
  public static class Matcher extends BaseMatcher<SriVariableDataPrototype.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static SriVariableDataPrototype.Matcher on(final ViatraQueryEngine engine) {
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
    public static SriVariableDataPrototype.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_UMLCLASS = 0;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(SriVariableDataPrototype.Matcher.class);

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
     * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<SriVariableDataPrototype.Match> getAllMatches(final org.eclipse.uml2.uml.Class pUmlClass) {
      return rawStreamAllMatches(new Object[]{pUmlClass}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<SriVariableDataPrototype.Match> streamAllMatches(final org.eclipse.uml2.uml.Class pUmlClass) {
      return rawStreamAllMatches(new Object[]{pUmlClass});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<SriVariableDataPrototype.Match> getOneArbitraryMatch(final org.eclipse.uml2.uml.Class pUmlClass) {
      return rawGetOneArbitraryMatch(new Object[]{pUmlClass});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final org.eclipse.uml2.uml.Class pUmlClass) {
      return rawHasMatch(new Object[]{pUmlClass});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final org.eclipse.uml2.uml.Class pUmlClass) {
      return rawCountMatches(new Object[]{pUmlClass});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Consumer<? super SriVariableDataPrototype.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pUmlClass}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public SriVariableDataPrototype.Match newMatch(final org.eclipse.uml2.uml.Class pUmlClass) {
      return SriVariableDataPrototype.Match.newMatch(pUmlClass);
    }

    /**
     * Retrieve the set of values that occur in matches for umlClass.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<org.eclipse.uml2.uml.Class> rawStreamAllValuesOfumlClass(final Object[] parameters) {
      return rawStreamAllValues(POSITION_UMLCLASS, parameters).map(org.eclipse.uml2.uml.Class.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for umlClass.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<org.eclipse.uml2.uml.Class> getAllValuesOfumlClass() {
      return rawStreamAllValuesOfumlClass(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlClass.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<org.eclipse.uml2.uml.Class> streamAllValuesOfumlClass() {
      return rawStreamAllValuesOfumlClass(emptyArray());
    }

    @Override
    protected SriVariableDataPrototype.Match tupleToMatch(final Tuple t) {
      try {
          return SriVariableDataPrototype.Match.newMatch((org.eclipse.uml2.uml.Class) t.get(POSITION_UMLCLASS));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected SriVariableDataPrototype.Match arrayToMatch(final Object[] match) {
      try {
          return SriVariableDataPrototype.Match.newMatch((org.eclipse.uml2.uml.Class) match[POSITION_UMLCLASS]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected SriVariableDataPrototype.Match arrayToMatchMutable(final Object[] match) {
      try {
          return SriVariableDataPrototype.Match.newMutableMatch((org.eclipse.uml2.uml.Class) match[POSITION_UMLCLASS]);
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
    public static IQuerySpecification<SriVariableDataPrototype.Matcher> querySpecification() {
      return SriVariableDataPrototype.instance();
    }
  }

  private SriVariableDataPrototype() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static SriVariableDataPrototype instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected SriVariableDataPrototype.Matcher instantiate(final ViatraQueryEngine engine) {
    return SriVariableDataPrototype.Matcher.on(engine);
  }

  @Override
  public SriVariableDataPrototype.Matcher instantiate() {
    return SriVariableDataPrototype.Matcher.create();
  }

  @Override
  public SriVariableDataPrototype.Match newEmptyMatch() {
    return SriVariableDataPrototype.Match.newEmptyMatch();
  }

  @Override
  public SriVariableDataPrototype.Match newMatch(final Object... parameters) {
    return SriVariableDataPrototype.Match.newMatch((org.eclipse.uml2.uml.Class) parameters[0]);
  }

  /**
   * Inner class allowing the singleton instance of {@link SriVariableDataPrototype} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link SriVariableDataPrototype#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final SriVariableDataPrototype INSTANCE = new SriVariableDataPrototype();

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
    private static final SriVariableDataPrototype.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_umlClass = new PParameter("umlClass", "org.eclipse.uml2.uml.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Class")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_umlClass);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.sysml2autosar.queries.sriVariableDataPrototype";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("umlClass");
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
          PVariable var_umlClass = body.getOrCreateVariableByName("umlClass");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
          PVariable var_umlName = body.getOrCreateVariableByName("umlName");
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlClass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_umlClass, parameter_umlClass)
          ));
          // 	InterfaceBlock.base_Class(_, umlClass)
          new TypeConstraint(body, Tuples.flatTupleOf(var___0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/papyrus/sysml/1.6/SysML/PortsAndFlows", "InterfaceBlock")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var___0_, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/papyrus/sysml/1.6/SysML/Blocks", "Block", "base_Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
          new Equality(body, var__virtual_0_, var_umlClass);
          // 	Class.ownedAttribute(umlClass, _)
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlClass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlClass, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StructuredClassifier", "ownedAttribute")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
          new Equality(body, var__virtual_1_, var___1_);
          // 	Class.ownedAttribute.name(umlClass, umlName)
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlClass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlClass, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StructuredClassifier", "ownedAttribute")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/Types", "String")));
          new Equality(body, var__virtual_3_, var_umlName);
          // 	check(umlName.startsWith("vdp_"))
          new ExpressionEvaluation(body, new IExpressionEvaluator() {
          
              @Override
              public String getShortDescription() {
                  return "Expression evaluation from pattern sriVariableDataPrototype";
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
    boolean _startsWith = umlName.startsWith("vdp_");
    return _startsWith;
  }
}
