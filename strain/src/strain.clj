(ns strain)


(defn retain
  "Keeps the items in coll for which (pred item) returns true."
  [pred coll]
  (reduce (fn [acc n] (if (pred n)
                        (conj acc n)
                        acc)) [] coll))

(defn retain                                                ;; list comprehension
  [pred coll]
  (for [n coll :when (pred n)] n))

;; --


(defn discard
  "Removes the items in coll for which (pred item) returns true."
  [pred coll]
  (reduce (fn [acc n] (if (pred n)
                        acc
                        (conj acc n))) [] coll))

(defn discard
  [pred coll]
  (retain (complement pred) coll))

