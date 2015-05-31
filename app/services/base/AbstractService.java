package services.base;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import services.exceptions.NotFoundException;
import utils.HbUtils;

import javax.inject.Named;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by eduardo on 12/03/15.
 */
@Named
@Transactional
public abstract class AbstractService < T, I extends Serializable > implements GenericService< T, I > {
	JpaRepository< T, I > repo;


	public AbstractService( JpaRepository< T, I > repo ) {
		this.repo = repo;
	}

	/**
	 * Creates a new set of elements.
	 *
	 * @param entity The information of the created element.
	 *
	 * @return The created element.
	 */

	@Transactional
	@Override
	public Iterable< T > save( Iterable< T > entity ) {
		return repo.save( entity );
	}

	/**
	 * Creates a new element.
	 *
	 * @param entity The information of the created element.
	 *
	 * @return The created element.
	 */

	@Transactional
	@Override
	public T save( T entity ) {
		return repo.save( entity );
	}

	/**
	 * Updates the information of a element.
	 *
	 * @param updated The information of the updated element.
	 *
	 * @return The updated element.
	 *
	 * @throws services.exceptions.NotFoundException if no element is found with given id.
	 */
	@Transactional( rollbackFor = NotFoundException.class )
	@Override
	public T update( I id, Object updated ) throws NotFoundException {
		T u = repo.findOne( id );

		if ( u == null ) {
			throw new NotFoundException();
		}

		copyProperties( updated, u );

		u = repo.save( u );

		return u;

	}

	/**
	 * Deletes a person.
	 *
	 * @param id The id of the deleted person.
	 *
	 * @return The deleted person.
	 *
	 * @throws NotFoundException if no person is found with the given id.
	 */
	@Transactional( rollbackFor = NotFoundException.class )
	@Override
	public boolean delete( I id ) throws NotFoundException {
		T o = repo.getOne( id );
		if ( o == null ) {
			throw new NotFoundException();
		} else {
			repo.delete( o );
		}

		return true;
	}

	/**
	 * Finds all persons.
	 *
	 * @return A list of persons.
	 */
	@Transactional( readOnly = true )
	@Override
	public List< T > findAll() {
		return repo.findAll();
	}

	/**
	 * Finds person by id.
	 *
	 * @param id The id of the wanted person.
	 *
	 * @return The found person. If no person is found, this method returns null.
	 */
	@Transactional( readOnly = true )
	@Override
	public T findById( I id ) {
		T o = repo.getOne( id );
		if ( o != null ) {
			return HbUtils.deproxy( o );
		} else {
			return null;
		}
	}

	@Override
	public String[] getNullPropertyNames( Object source ) {
		final BeanWrapper src = new BeanWrapperImpl( source );
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

		Set< String > emptyNames = new HashSet< String >();
		for ( java.beans.PropertyDescriptor pd : pds ) {
			Object srcValue = src.getPropertyValue( pd.getName() );
			if ( srcValue == null ) {
				emptyNames.add( pd.getName() );
			}
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray( result );
	}

	// then use Spring BeanUtils to copy and ignore null
	@Override
	public void copyProperties( Object src, Object target ) {
		BeanUtils.copyProperties( src, target, getNullPropertyNames( src ) );
	}

}
