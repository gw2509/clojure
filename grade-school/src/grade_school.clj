(ns grade-school)

(defn grade [school grade]
  (school grade []))


(defn add [school name grade]
  (if-let [g (get school grade)]
    (assoc school grade (conj g name))
    (assoc school grade [name])))

;; better
(defn add [school name grade]
  (assoc school grade (conj (school grade []) name)))

(defn sorted [school]
  (into (sorted-map)
        (for [[grade students] school]
          [grade (sort students)])))