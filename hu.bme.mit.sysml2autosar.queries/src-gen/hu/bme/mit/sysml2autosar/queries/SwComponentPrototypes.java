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
import org.eclipse.uml2.uml.Property;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
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
 *         pattern swComponentPrototypes(umlClass: UML::Class, umlProperty: UML::Property){
 *         	Block.base_Class(_, umlClass); // Has {@literal <}{@literal <}Block{@literal >}{@literal >} Stereotype defined
 *         	Class.ownedAttribute(umlClass, umlProperty);
 *         	Property.ownedElement(umlProperty, umlPort);
 *         	Port(umlPort);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class SwComponentPrototypes extends BaseGeneratedEMFQuerySpecification<SwComponentPrototypes.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.sysml2autosar.queries.swComponentPrototypes pattern,
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

    private Property fUmlProperty;

    private static List<String> parameterNames = makeImmutableList("umlClass", "umlProperty");

    private Match(final org.eclipse.uml2.uml.Class pUmlClass, final Property pUmlProperty) {
      this.fUmlClass = pUmlClass;
      this.fUmlProperty = pUmlProperty;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "umlClass": return this.fUmlClass;
          case "umlProperty": return this.fUmlProperty;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fUmlClass;
          case 1: return this.fUmlProperty;
          default: return null;
      }
    }

    public org.eclipse.uml2.uml.Class getUmlClass() {
      return this.fUmlClass;
    }

    public Property getUmlProperty() {
      return this.fUmlProperty;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("umlClass".equals(parameterName) ) {
          this.fUmlClass = (org.eclipse.uml2.uml.Class) newValue;
          return true;
      }
      if ("umlProperty".equals(parameterName) ) {
          this.fUmlProperty = (Property) newValue;
          return true;
      }
      return false;
    }

    public void setUmlClass(final org.eclipse.uml2.uml.Class pUmlClass) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fUmlClass = pUmlClass;
    }

    public void setUmlProperty(final Property pUmlProperty) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fUmlProperty = pUmlProperty;
    }

    @Override
    public String patternName() {
      return "hu.bme.mit.sysml2autosar.queries.swComponentPrototypes";
    }

    @Override
    public List<String> parameterNames() {
      return SwComponentPrototypes.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fUmlClass, fUmlProperty};
    }

    @Override
    public SwComponentPrototypes.Match toImmutable() {
      return isMutable() ? newMatch(fUmlClass, fUmlProperty) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"umlClass\"=" + prettyPrintValue(fUmlClass) + ", ");
      result.append("\"umlProperty\"=" + prettyPrintValue(fUmlProperty));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fUmlClass, fUmlProperty);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof SwComponentPrototypes.Match)) {
          SwComponentPrototypes.Match other = (SwComponentPrototypes.Match) obj;
          return Objects.equals(fUmlClass, other.fUmlClass) && Objects.equals(fUmlProperty, other.fUmlProperty);
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
    public SwComponentPrototypes specification() {
      return SwComponentPrototypes.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static SwComponentPrototypes.Match newEmptyMatch() {
      return new Mutable(null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static SwComponentPrototypes.Match newMutableMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Property pUmlProperty) {
      return new Mutable(pUmlClass, pUmlProperty);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static SwComponentPrototypes.Match newMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Property pUmlProperty) {
      return new Immutable(pUmlClass, pUmlProperty);
    }

    private static final class Mutable extends SwComponentPrototypes.Match {
      Mutable(final org.eclipse.uml2.uml.Class pUmlClass, final Property pUmlProperty) {
        super(pUmlClass, pUmlProperty);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends SwComponentPrototypes.Match {
      Immutable(final org.eclipse.uml2.uml.Class pUmlClass, final Property pUmlProperty) {
        super(pUmlClass, pUmlProperty);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the hu.bme.mit.sysml2autosar.queries.swComponentPrototypes pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern swComponentPrototypes(umlClass: UML::Class, umlProperty: UML::Property){
   * 	Block.base_Class(_, umlClass); // Has {@literal <}{@literal <}Block{@literal >}{@literal >} Stereotype defined
   * 	Class.ownedAttribute(umlClass, umlProperty);
   * 	Property.ownedElement(umlProperty, umlPort);
   * 	Port(umlPort);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see SwComponentPrototypes
   * 
   */
  public static class Matcher extends BaseMatcher<SwComponentPrototypes.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static SwComponentPrototypes.Matcher on(final ViatraQueryEngine engine) {
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
    public static SwComponentPrototypes.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_UMLCLASS = 0;

    private static final int POSITION_UMLPROPERTY = 1;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(SwComponentPrototypes.Matcher.class);

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
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<SwComponentPrototypes.Match> getAllMatches(final org.eclipse.uml2.uml.Class pUmlClass, final Property pUmlProperty) {
      return rawStreamAllMatches(new Object[]{pUmlClass, pUmlProperty}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<SwComponentPrototypes.Match> streamAllMatches(final org.eclipse.uml2.uml.Class pUmlClass, final Property pUmlProperty) {
      return rawStreamAllMatches(new Object[]{pUmlClass, pUmlProperty});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<SwComponentPrototypes.Match> getOneArbitraryMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Property pUmlProperty) {
      return rawGetOneArbitraryMatch(new Object[]{pUmlClass, pUmlProperty});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Property pUmlProperty) {
      return rawHasMatch(new Object[]{pUmlClass, pUmlProperty});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final org.eclipse.uml2.uml.Class pUmlClass, final Property pUmlProperty) {
      return rawCountMatches(new Object[]{pUmlClass, pUmlProperty});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Property pUmlProperty, final Consumer<? super SwComponentPrototypes.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pUmlClass, pUmlProperty}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pUmlClass the fixed value of pattern parameter umlClass, or null if not bound.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public SwComponentPrototypes.Match newMatch(final org.eclipse.uml2.uml.Class pUmlClass, final Property pUmlProperty) {
      return SwComponentPrototypes.Match.newMatch(pUmlClass, pUmlProperty);
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

    /**
     * Retrieve the set of values that occur in matches for umlClass.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<org.eclipse.uml2.uml.Class> streamAllValuesOfumlClass(final SwComponentPrototypes.Match partialMatch) {
      return rawStreamAllValuesOfumlClass(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlClass.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<org.eclipse.uml2.uml.Class> streamAllValuesOfumlClass(final Property pUmlProperty) {
      return rawStreamAllValuesOfumlClass(new Object[]{null, pUmlProperty});
    }

    /**
     * Retrieve the set of values that occur in matches for umlClass.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<org.eclipse.uml2.uml.Class> getAllValuesOfumlClass(final SwComponentPrototypes.Match partialMatch) {
      return rawStreamAllValuesOfumlClass(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlClass.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<org.eclipse.uml2.uml.Class> getAllValuesOfumlClass(final Property pUmlProperty) {
      return rawStreamAllValuesOfumlClass(new Object[]{null, pUmlProperty}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlProperty.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Property> rawStreamAllValuesOfumlProperty(final Object[] parameters) {
      return rawStreamAllValues(POSITION_UMLPROPERTY, parameters).map(Property.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for umlProperty.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Property> getAllValuesOfumlProperty() {
      return rawStreamAllValuesOfumlProperty(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlProperty.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Property> streamAllValuesOfumlProperty() {
      return rawStreamAllValuesOfumlProperty(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlProperty.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Property> streamAllValuesOfumlProperty(final SwComponentPrototypes.Match partialMatch) {
      return rawStreamAllValuesOfumlProperty(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlProperty.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Property> streamAllValuesOfumlProperty(final org.eclipse.uml2.uml.Class pUmlClass) {
      return rawStreamAllValuesOfumlProperty(new Object[]{pUmlClass, null});
    }

    /**
     * Retrieve the set of values that occur in matches for umlProperty.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Property> getAllValuesOfumlProperty(final SwComponentPrototypes.Match partialMatch) {
      return rawStreamAllValuesOfumlProperty(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlProperty.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Property> getAllValuesOfumlProperty(final org.eclipse.uml2.uml.Class pUmlClass) {
      return rawStreamAllValuesOfumlProperty(new Object[]{pUmlClass, null}).collect(Collectors.toSet());
    }

    @Override
    protected SwComponentPrototypes.Match tupleToMatch(final Tuple t) {
      try {
          return SwComponentPrototypes.Match.newMatch((org.eclipse.uml2.uml.Class) t.get(POSITION_UMLCLASS), (Property) t.get(POSITION_UMLPROPERTY));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected SwComponentPrototypes.Match arrayToMatch(final Object[] match) {
      try {
          return SwComponentPrototypes.Match.newMatch((org.eclipse.uml2.uml.Class) match[POSITION_UMLCLASS], (Property) match[POSITION_UMLPROPERTY]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected SwComponentPrototypes.Match arrayToMatchMutable(final Object[] match) {
      try {
          return SwComponentPrototypes.Match.newMutableMatch((org.eclipse.uml2.uml.Class) match[POSITION_UMLCLASS], (Property) match[POSITION_UMLPROPERTY]);
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
    public static IQuerySpecification<SwComponentPrototypes.Matcher> querySpecification() {
      return SwComponentPrototypes.instance();
    }
  }

  private SwComponentPrototypes() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static SwComponentPrototypes instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected SwComponentPrototypes.Matcher instantiate(final ViatraQueryEngine engine) {
    return SwComponentPrototypes.Matcher.on(engine);
  }

  @Override
  public SwComponentPrototypes.Matcher instantiate() {
    return SwComponentPrototypes.Matcher.create();
  }

  @Override
  public SwComponentPrototypes.Match newEmptyMatch() {
    return SwComponentPrototypes.Match.newEmptyMatch();
  }

  @Override
  public SwComponentPrototypes.Match newMatch(final Object... parameters) {
    return SwComponentPrototypes.Match.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Property) parameters[1]);
  }

  /**
   * Inner class allowing the singleton instance of {@link SwComponentPrototypes} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link SwComponentPrototypes#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final SwComponentPrototypes INSTANCE = new SwComponentPrototypes();

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
    private static final SwComponentPrototypes.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_umlClass = new PParameter("umlClass", "org.eclipse.uml2.uml.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Class")), PParameterDirection.INOUT);

    private final PParameter parameter_umlProperty = new PParameter("umlProperty", "org.eclipse.uml2.uml.Property", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Property")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_umlClass, parameter_umlProperty);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.sysml2autosar.queries.swComponentPrototypes";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("umlClass","umlProperty");
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
          PVariable var_umlProperty = body.getOrCreateVariableByName("umlProperty");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var_umlPort = body.getOrCreateVariableByName("umlPort");
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlClass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlProperty), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_umlClass, parameter_umlClass),
             new ExportedParameter(body, var_umlProperty, parameter_umlProperty)
          ));
          // 	Block.base_Class(_, umlClass)
          new TypeConstraint(body, Tuples.flatTupleOf(var___0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/papyrus/sysml/1.6/SysML/Blocks", "Block")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var___0_, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/papyrus/sysml/1.6/SysML/Blocks", "Block", "base_Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
          new Equality(body, var__virtual_0_, var_umlClass);
          //  // Has <<Block>> Stereotype defined	Class.ownedAttribute(umlClass, umlProperty)
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlClass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlClass, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StructuredClassifier", "ownedAttribute")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
          new Equality(body, var__virtual_1_, var_umlProperty);
          // 	Property.ownedElement(umlProperty, umlPort)
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlProperty), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlProperty, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element", "ownedElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element")));
          new Equality(body, var__virtual_2_, var_umlPort);
          // 	Port(umlPort)
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlPort), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Port")));
          bodies.add(body);
      }
      return bodies;
    }
  }
}
