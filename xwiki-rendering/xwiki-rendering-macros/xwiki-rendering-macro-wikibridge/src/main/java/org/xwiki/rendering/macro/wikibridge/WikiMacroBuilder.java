/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.xwiki.rendering.macro.wikibridge;

import org.xwiki.component.annotation.ComponentRole;

/**
 * Component interface for defining wiki macro builders.
 * 
 * @version $Id$
 * @since 2.0M2
 */
@ComponentRole
public interface WikiMacroBuilder
{
    /**
     * Searches the given document for a wiki macro definition.
     * 
     * @param documentName name of the document to search for a wiki macro definition.
     * @return true if the given document contains a wiki macro definition, false otherwise.
     */
    boolean containsMacro(String documentName);
    
    /**
     * Tries to build a {@link WikiMacro} if a definition is found on the given document.
     * 
     * @param documentName name of the document on which the macro is defined.
     * @return a {@link WikiMacro} corresponding to the macro definition found.
     * @throws WikiMacroBuilderException if no macro definition is found or if an error is encountered while building
     *             the macro.
     */
    WikiMacro buildMacro(String documentName) throws WikiMacroBuilderException;
}
