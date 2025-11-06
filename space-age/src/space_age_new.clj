(ns space-age-new)

(def ^:private seconds-in-year (* 365.25 24 60 60))

(def ^:private factors {:mercury 0.2408467
                        :venus   0.61519726
                        :earth   1.0
                        :mars    1.8808158
                        :jupiter 11.862615
                        :saturn  29.447498
                        :uranus  84.016846
                        :neptune 164.79132})

;; THIS IS QUITE COOL..

;; Dynamically generates functions for calculating age on different planets.
;; For each planet and its orbital factor in the 'factors' map:
;; - Creates a function name in the format "on-<planet>" (e.g., "on-earth")
;; - Defines a function that takes age in seconds and converts it to planet years
;; - The calculation divides seconds by Earth years, then by planet's orbital factor
;; This creates functions like on-earth, on-mars, etc. at runtime
(doseq [[planet factor] factors]
  (let [fn-name (symbol (str "on-" (name planet)))]
    (intern *ns* fn-name
            (fn [seconds]
              (/ (/ seconds seconds-in-year) factor)))))