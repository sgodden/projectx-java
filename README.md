TODO - look at using mongojack.org to handle the persistence

Use a 'FooReference' paradigm to provide references to other entities.

E.g. OrderLine would have a PacageTypeRef instance which only had an id on it.  This could have a method to retrieve the
full object, which was marked transient so that the persistence mechanism did not see it as part of the entity document.