/*
 * File    : ShareResourceFileImpl.java
 * Created : 02-Jan-2004
 * By      : parg
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details ( see the LICENSE file ).
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package com.biglybt.pifimpl.local.sharing;

/**
 * @author parg
 *
 */

import java.io.File;
import java.util.Map;

import com.biglybt.pif.sharing.ShareException;
import com.biglybt.pif.sharing.ShareResourceFile;

public class
ShareResourceFileImpl
	extends 	ShareResourceFileOrDirImpl
	implements 	ShareResourceFile
{
	protected static ShareResourceFileImpl
	getResource(
		ShareManagerImpl	_manager,
		File				_file )

		throws ShareException
	{
		ShareResourceImpl	res = ShareResourceFileOrDirImpl.getResourceSupport( _manager, _file );

		if ( res instanceof ShareResourceFileImpl ){

			return((ShareResourceFileImpl)res);
		}

		return( null );
	}

	protected
	ShareResourceFileImpl(
		ShareManagerImpl				_manager,
		ShareResourceDirContentsImpl	_parent,
		File							_file,
		boolean							_personal,
		Map<String,String>				_properties )

		throws ShareException
	{
		super( _manager, _parent, ST_FILE, _file, _personal,_properties );
	}

	protected
	ShareResourceFileImpl(
		ShareManagerImpl	_manager,
		File				_file,
		Map					_map)

		throws ShareException
	{
		super( _manager, ST_FILE, _file, _map );
	}

	@Override
	protected byte[]
	getFingerPrint()

		throws ShareException
	{
		return( getFingerPrint( getFile()));
	}
}
