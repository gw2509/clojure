(ns sublist)

(defn sub-list?
  [coll1 coll2]
  (some #{coll1} (partition (count coll1) 1 coll2)))

(defn classify
  "Returns:
  :equal if coll1 equals coll2,
  :superlist if coll1 is a superlist of coll2,
  :sublist if coll1 is a sublist of coll2,

  If none of these conditions is true, it returns :unequal."
  [coll1 coll2]
  (cond
    (= coll1 coll2) :equal
    (sub-list? coll1 coll2) :sublist
    (sub-list? coll2 coll1) :superlist
    :else :unequal))

