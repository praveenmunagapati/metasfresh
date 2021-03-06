package de.metas.material.event.pporder;

import org.eevolution.model.I_PP_Order;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.metas.material.event.MaterialEvent;
import de.metas.material.event.commons.EventDescriptor;
import de.metas.material.event.commons.SupplyRequiredDescriptor;
import de.metas.material.event.supplyrequired.SupplyRequiredEvent;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

/*
 * #%L
 * metasfresh-material-event
 * %%
 * Copyright (C) 2017 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */
/**
 * Send by the material planner when it came up with a brilliant production plan that could be turned into an {@link I_PP_Order} <b>or</or> if a ppOrder was actually created or changed.
 *
 * @author metas-dev <dev@metasfresh.com>
 *
 */
@Value // this implies @AllArgsConstructor which is needed by jackson
@Builder
final public class PPOrderAdvisedOrCreatedEvent implements MaterialEvent
{
	public static final String TYPE = "PPOrderAdvisedOrCreatedEvent";

	@NonNull
	EventDescriptor eventDescriptor;

	@NonNull
	PPOrder ppOrder;

	/**
	 * Set to > 0 if this event is about a "real" PPOrder that was created due to a {@link PPOrderRequestedEvent}.
	 */
	@JsonProperty
	int groupId;

	/**
	 * Set to not-null mainly if this event is about and "advise" that was created due to a {@link SupplyRequiredEvent}, but also<br>
	 * if this event is about a "wild" PPOrder that was somehow created and has a sale order line ID
	 */
	SupplyRequiredDescriptor supplyRequiredDescriptor;
}
