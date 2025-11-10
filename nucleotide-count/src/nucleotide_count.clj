(ns nucleotide-count)


(defn count-of-nucleotide-in-strand [nucleotide strand]
  (if (re-find #"[ACGT]" (str nucleotide))
    (count (filter #(= % nucleotide) strand))
    (throw (IllegalArgumentException. "Invalid nucleotide"))))

(defn nucleotide-counts [strand]
  (into
    {\A 0, \T 0, \C 0, \G 0}
    (frequencies strand)))


;; or..


(defn count-of-nucleotide-in-strand [nucleotide strand]
  {:pre [(contains? #{\A \T \G \C} nucleotide)]}
  ((nucleotide-counts strand) nucleotide))

(defn nucleotide-counts [strand]
  (merge
    {\A 0, \T 0, \C 0, \G 0}
    (frequencies strand)))
