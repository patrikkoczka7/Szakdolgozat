/**
 * Generated from platform:/resource/hu.bme.mit.sysml2autosar.queries/src/hu/bme/mit/sysml2autosar/queries/patterns.vql
 */
package hu.bme.mit.sysml2autosar.queries;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Property;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
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
 *         pattern sriVariableDataPrototype(umlSri: UML::Class, umlProperty: UML::Property, umlAppPrimDataType: UML::DataType){
 *         	find applicationDataType(umlAppPrimDataType);
 *         	find senderReceiverInterfaceType(umlSri);
 *         	Class.ownedAttribute(umlSri, umlProperty);
 *         	Property.name(umlProperty, _);
 *         	neg Port(umlProperty);
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
    private org.eclipse.uml2.uml.Class fUmlSri;

    private Property fUmlProperty;

    private DataType fUmlAppPrimDataType;

    private static List<String> parameterNames = makeImmutableList("umlSri", "umlProperty", "umlAppPrimDataType");

    private Match(final org.eclipse.uml2.uml.Class pUmlSri, final Property pUmlProperty, final DataType pUmlAppPrimDataType) {
      this.fUmlSri = pUmlSri;
      this.fUmlProperty = pUmlProperty;
      this.fUmlAppPrimDataType = pUmlAppPrimDataType;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "umlSri": return this.fUmlSri;
          case "umlProperty": return this.fUmlProperty;
          case "umlAppPrimDataType": return this.fUmlAppPrimDataType;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fUmlSri;
          case 1: return this.fUmlProperty;
          case 2: return this.fUmlAppPrimDataType;
          default: return null;
      }
    }

    public org.eclipse.uml2.uml.Class getUmlSri() {
      return this.fUmlSri;
    }

    public Property getUmlProperty() {
      return this.fUmlProperty;
    }

    public DataType getUmlAppPrimDataType() {
      return this.fUmlAppPrimDataType;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("umlSri".equals(parameterName) ) {
          this.fUmlSri = (org.eclipse.uml2.uml.Class) newValue;
          return true;
      }
      if ("umlProperty".equals(parameterName) ) {
          this.fUmlProperty = (Property) newValue;
          return true;
      }
      if ("umlAppPrimDataType".equals(parameterName) ) {
          this.fUmlAppPrimDataType = (DataType) newValue;
          return true;
      }
      return false;
    }

    public void setUmlSri(final org.eclipse.uml2.uml.Class pUmlSri) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fUmlSri = pUmlSri;
    }

    public void setUmlProperty(final Property pUmlProperty) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fUmlProperty = pUmlProperty;
    }

    public void setUmlAppPrimDataType(final DataType pUmlAppPrimDataType) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fUmlAppPrimDataType = pUmlAppPrimDataType;
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
      return new Object[]{fUmlSri, fUmlProperty, fUmlAppPrimDataType};
    }

    @Override
    public SriVariableDataPrototype.Match toImmutable() {
      return isMutable() ? newMatch(fUmlSri, fUmlProperty, fUmlAppPrimDataType) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"umlSri\"=" + prettyPrintValue(fUmlSri) + ", ");
      result.append("\"umlProperty\"=" + prettyPrintValue(fUmlProperty) + ", ");
      result.append("\"umlAppPrimDataType\"=" + prettyPrintValue(fUmlAppPrimDataType));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fUmlSri, fUmlProperty, fUmlAppPrimDataType);
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
          return Objects.equals(fUmlSri, other.fUmlSri) && Objects.equals(fUmlProperty, other.fUmlProperty) && Objects.equals(fUmlAppPrimDataType, other.fUmlAppPrimDataType);
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
      return new Mutable(null, null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pUmlSri the fixed value of pattern parameter umlSri, or null if not bound.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @param pUmlAppPrimDataType the fixed value of pattern parameter umlAppPrimDataType, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static SriVariableDataPrototype.Match newMutableMatch(final org.eclipse.uml2.uml.Class pUmlSri, final Property pUmlProperty, final DataType pUmlAppPrimDataType) {
      return new Mutable(pUmlSri, pUmlProperty, pUmlAppPrimDataType);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pUmlSri the fixed value of pattern parameter umlSri, or null if not bound.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @param pUmlAppPrimDataType the fixed value of pattern parameter umlAppPrimDataType, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static SriVariableDataPrototype.Match newMatch(final org.eclipse.uml2.uml.Class pUmlSri, final Property pUmlProperty, final DataType pUmlAppPrimDataType) {
      return new Immutable(pUmlSri, pUmlProperty, pUmlAppPrimDataType);
    }

    private static final class Mutable extends SriVariableDataPrototype.Match {
      Mutable(final org.eclipse.uml2.uml.Class pUmlSri, final Property pUmlProperty, final DataType pUmlAppPrimDataType) {
        super(pUmlSri, pUmlProperty, pUmlAppPrimDataType);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends SriVariableDataPrototype.Match {
      Immutable(final org.eclipse.uml2.uml.Class pUmlSri, final Property pUmlProperty, final DataType pUmlAppPrimDataType) {
        super(pUmlSri, pUmlProperty, pUmlAppPrimDataType);
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
   * pattern sriVariableDataPrototype(umlSri: UML::Class, umlProperty: UML::Property, umlAppPrimDataType: UML::DataType){
   * 	find applicationDataType(umlAppPrimDataType);
   * 	find senderReceiverInterfaceType(umlSri);
   * 	Class.ownedAttribute(umlSri, umlProperty);
   * 	Property.name(umlProperty, _);
   * 	neg Port(umlProperty);
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

    private static final int POSITION_UMLSRI = 0;

    private static final int POSITION_UMLPROPERTY = 1;

    private static final int POSITION_UMLAPPPRIMDATATYPE = 2;

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
     * @param pUmlSri the fixed value of pattern parameter umlSri, or null if not bound.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @param pUmlAppPrimDataType the fixed value of pattern parameter umlAppPrimDataType, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<SriVariableDataPrototype.Match> getAllMatches(final org.eclipse.uml2.uml.Class pUmlSri, final Property pUmlProperty, final DataType pUmlAppPrimDataType) {
      return rawStreamAllMatches(new Object[]{pUmlSri, pUmlProperty, pUmlAppPrimDataType}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pUmlSri the fixed value of pattern parameter umlSri, or null if not bound.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @param pUmlAppPrimDataType the fixed value of pattern parameter umlAppPrimDataType, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<SriVariableDataPrototype.Match> streamAllMatches(final org.eclipse.uml2.uml.Class pUmlSri, final Property pUmlProperty, final DataType pUmlAppPrimDataType) {
      return rawStreamAllMatches(new Object[]{pUmlSri, pUmlProperty, pUmlAppPrimDataType});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pUmlSri the fixed value of pattern parameter umlSri, or null if not bound.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @param pUmlAppPrimDataType the fixed value of pattern parameter umlAppPrimDataType, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<SriVariableDataPrototype.Match> getOneArbitraryMatch(final org.eclipse.uml2.uml.Class pUmlSri, final Property pUmlProperty, final DataType pUmlAppPrimDataType) {
      return rawGetOneArbitraryMatch(new Object[]{pUmlSri, pUmlProperty, pUmlAppPrimDataType});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pUmlSri the fixed value of pattern parameter umlSri, or null if not bound.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @param pUmlAppPrimDataType the fixed value of pattern parameter umlAppPrimDataType, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final org.eclipse.uml2.uml.Class pUmlSri, final Property pUmlProperty, final DataType pUmlAppPrimDataType) {
      return rawHasMatch(new Object[]{pUmlSri, pUmlProperty, pUmlAppPrimDataType});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pUmlSri the fixed value of pattern parameter umlSri, or null if not bound.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @param pUmlAppPrimDataType the fixed value of pattern parameter umlAppPrimDataType, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final org.eclipse.uml2.uml.Class pUmlSri, final Property pUmlProperty, final DataType pUmlAppPrimDataType) {
      return rawCountMatches(new Object[]{pUmlSri, pUmlProperty, pUmlAppPrimDataType});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pUmlSri the fixed value of pattern parameter umlSri, or null if not bound.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @param pUmlAppPrimDataType the fixed value of pattern parameter umlAppPrimDataType, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Class pUmlSri, final Property pUmlProperty, final DataType pUmlAppPrimDataType, final Consumer<? super SriVariableDataPrototype.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pUmlSri, pUmlProperty, pUmlAppPrimDataType}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pUmlSri the fixed value of pattern parameter umlSri, or null if not bound.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @param pUmlAppPrimDataType the fixed value of pattern parameter umlAppPrimDataType, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public SriVariableDataPrototype.Match newMatch(final org.eclipse.uml2.uml.Class pUmlSri, final Property pUmlProperty, final DataType pUmlAppPrimDataType) {
      return SriVariableDataPrototype.Match.newMatch(pUmlSri, pUmlProperty, pUmlAppPrimDataType);
    }

    /**
     * Retrieve the set of values that occur in matches for umlSri.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<org.eclipse.uml2.uml.Class> rawStreamAllValuesOfumlSri(final Object[] parameters) {
      return rawStreamAllValues(POSITION_UMLSRI, parameters).map(org.eclipse.uml2.uml.Class.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for umlSri.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<org.eclipse.uml2.uml.Class> getAllValuesOfumlSri() {
      return rawStreamAllValuesOfumlSri(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlSri.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<org.eclipse.uml2.uml.Class> streamAllValuesOfumlSri() {
      return rawStreamAllValuesOfumlSri(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlSri.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<org.eclipse.uml2.uml.Class> streamAllValuesOfumlSri(final SriVariableDataPrototype.Match partialMatch) {
      return rawStreamAllValuesOfumlSri(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlSri.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<org.eclipse.uml2.uml.Class> streamAllValuesOfumlSri(final Property pUmlProperty, final DataType pUmlAppPrimDataType) {
      return rawStreamAllValuesOfumlSri(new Object[]{null, pUmlProperty, pUmlAppPrimDataType});
    }

    /**
     * Retrieve the set of values that occur in matches for umlSri.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<org.eclipse.uml2.uml.Class> getAllValuesOfumlSri(final SriVariableDataPrototype.Match partialMatch) {
      return rawStreamAllValuesOfumlSri(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlSri.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<org.eclipse.uml2.uml.Class> getAllValuesOfumlSri(final Property pUmlProperty, final DataType pUmlAppPrimDataType) {
      return rawStreamAllValuesOfumlSri(new Object[]{null, pUmlProperty, pUmlAppPrimDataType}).collect(Collectors.toSet());
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
    public Stream<Property> streamAllValuesOfumlProperty(final SriVariableDataPrototype.Match partialMatch) {
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
    public Stream<Property> streamAllValuesOfumlProperty(final org.eclipse.uml2.uml.Class pUmlSri, final DataType pUmlAppPrimDataType) {
      return rawStreamAllValuesOfumlProperty(new Object[]{pUmlSri, null, pUmlAppPrimDataType});
    }

    /**
     * Retrieve the set of values that occur in matches for umlProperty.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Property> getAllValuesOfumlProperty(final SriVariableDataPrototype.Match partialMatch) {
      return rawStreamAllValuesOfumlProperty(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlProperty.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Property> getAllValuesOfumlProperty(final org.eclipse.uml2.uml.Class pUmlSri, final DataType pUmlAppPrimDataType) {
      return rawStreamAllValuesOfumlProperty(new Object[]{pUmlSri, null, pUmlAppPrimDataType}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlAppPrimDataType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<DataType> rawStreamAllValuesOfumlAppPrimDataType(final Object[] parameters) {
      return rawStreamAllValues(POSITION_UMLAPPPRIMDATATYPE, parameters).map(DataType.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for umlAppPrimDataType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DataType> getAllValuesOfumlAppPrimDataType() {
      return rawStreamAllValuesOfumlAppPrimDataType(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlAppPrimDataType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<DataType> streamAllValuesOfumlAppPrimDataType() {
      return rawStreamAllValuesOfumlAppPrimDataType(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlAppPrimDataType.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<DataType> streamAllValuesOfumlAppPrimDataType(final SriVariableDataPrototype.Match partialMatch) {
      return rawStreamAllValuesOfumlAppPrimDataType(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlAppPrimDataType.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<DataType> streamAllValuesOfumlAppPrimDataType(final org.eclipse.uml2.uml.Class pUmlSri, final Property pUmlProperty) {
      return rawStreamAllValuesOfumlAppPrimDataType(new Object[]{pUmlSri, pUmlProperty, null});
    }

    /**
     * Retrieve the set of values that occur in matches for umlAppPrimDataType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DataType> getAllValuesOfumlAppPrimDataType(final SriVariableDataPrototype.Match partialMatch) {
      return rawStreamAllValuesOfumlAppPrimDataType(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlAppPrimDataType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DataType> getAllValuesOfumlAppPrimDataType(final org.eclipse.uml2.uml.Class pUmlSri, final Property pUmlProperty) {
      return rawStreamAllValuesOfumlAppPrimDataType(new Object[]{pUmlSri, pUmlProperty, null}).collect(Collectors.toSet());
    }

    @Override
    protected SriVariableDataPrototype.Match tupleToMatch(final Tuple t) {
      try {
          return SriVariableDataPrototype.Match.newMatch((org.eclipse.uml2.uml.Class) t.get(POSITION_UMLSRI), (Property) t.get(POSITION_UMLPROPERTY), (DataType) t.get(POSITION_UMLAPPPRIMDATATYPE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected SriVariableDataPrototype.Match arrayToMatch(final Object[] match) {
      try {
          return SriVariableDataPrototype.Match.newMatch((org.eclipse.uml2.uml.Class) match[POSITION_UMLSRI], (Property) match[POSITION_UMLPROPERTY], (DataType) match[POSITION_UMLAPPPRIMDATATYPE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected SriVariableDataPrototype.Match arrayToMatchMutable(final Object[] match) {
      try {
          return SriVariableDataPrototype.Match.newMutableMatch((org.eclipse.uml2.uml.Class) match[POSITION_UMLSRI], (Property) match[POSITION_UMLPROPERTY], (DataType) match[POSITION_UMLAPPPRIMDATATYPE]);
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
    return SriVariableDataPrototype.Match.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Property) parameters[1], (org.eclipse.uml2.uml.DataType) parameters[2]);
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

    private final PParameter parameter_umlSri = new PParameter("umlSri", "org.eclipse.uml2.uml.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Class")), PParameterDirection.INOUT);

    private final PParameter parameter_umlProperty = new PParameter("umlProperty", "org.eclipse.uml2.uml.Property", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Property")), PParameterDirection.INOUT);

    private final PParameter parameter_umlAppPrimDataType = new PParameter("umlAppPrimDataType", "org.eclipse.uml2.uml.DataType", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "DataType")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_umlSri, parameter_umlProperty, parameter_umlAppPrimDataType);

    private class Embedded_1_Port extends BaseGeneratedEMFPQuery {
      private final PParameter parameter_p0 = new PParameter("p0", "org.eclipse.uml2.uml.Port", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Port")), PParameterDirection.INOUT);

      private final List<PParameter> embeddedParameters = Arrays.asList(parameter_p0);

      public Embedded_1_Port() {
        super(PVisibility.EMBEDDED);
      }

      @Override
      public String getFullyQualifiedName() {
        return GeneratedPQuery.this.getFullyQualifiedName() + "$Embedded_1_Port";
      }

      @Override
      public List<PParameter> getParameters() {
        return embeddedParameters;
      }

      @Override
      public Set<PBody> doGetContainedBodies() {
        PBody body = new PBody(this);
        PVariable var_p0 = body.getOrCreateVariableByName("p0");
        body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
           new ExportedParameter(body, var_p0, parameter_p0)
        ));
        //  Port(umlProperty)
        new TypeConstraint(body, Tuples.flatTupleOf(var_p0), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Port")));
        return Collections.singleton(body);
      }
    }

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.sysml2autosar.queries.sriVariableDataPrototype";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("umlSri","umlProperty","umlAppPrimDataType");
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
          PVariable var_umlSri = body.getOrCreateVariableByName("umlSri");
          PVariable var_umlProperty = body.getOrCreateVariableByName("umlProperty");
          PVariable var_umlAppPrimDataType = body.getOrCreateVariableByName("umlAppPrimDataType");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlSri), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlProperty), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlAppPrimDataType), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "DataType")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_umlSri, parameter_umlSri),
             new ExportedParameter(body, var_umlProperty, parameter_umlProperty),
             new ExportedParameter(body, var_umlAppPrimDataType, parameter_umlAppPrimDataType)
          ));
          // 	find applicationDataType(umlAppPrimDataType)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_umlAppPrimDataType), ApplicationDataType.instance().getInternalQueryRepresentation());
          // 	find senderReceiverInterfaceType(umlSri)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_umlSri), SenderReceiverInterfaceType.instance().getInternalQueryRepresentation());
          // 	Class.ownedAttribute(umlSri, umlProperty)
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlSri), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlSri, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "StructuredClassifier", "ownedAttribute")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
          new Equality(body, var__virtual_0_, var_umlProperty);
          // 	Property.name(umlProperty, _)
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlProperty), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlProperty, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "NamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/Types", "String")));
          new Equality(body, var__virtual_1_, var___0_);
          // 	neg Port(umlProperty)
          new NegativePatternCall(body, Tuples.flatTupleOf(var_umlProperty), new SriVariableDataPrototype.GeneratedPQuery.Embedded_1_Port());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
