# Percolation Threshold Estimation via Monte Carlo Simulation
This repository contains a program designed to estimate the percolation threshold of an n-by-n grid using Monte Carlo simulation. The percolation threshold is a critical value that indicates the point at which a system transitions from being non-percolative to percolative. This program leverages a probabilistic approach to approximate this value.

<img src="https://github.com/fsbonilha/PercolationUF/assets/54900275/22e7a915-9c3c-4e91-9353-1ba07307e557" alt="Description" width="300" height="230">

<img src="https://github.com/fsbonilha/PercolationUF/assets/54900275/c78c744e-4420-479d-964f-7e5745ba1b43" alt="Description" width="300" height="230">

This program is part of Algorithms, Part 1 Course by Princeton University. 


## Percolation Model
The percolation system is modeled using an n-by-n grid where each site can be either open or blocked. A site is considered "full" if it is open and connected to an open site in the top row through neighboring open sites. The system percolates if there is at least one full site in the bottom row.

## Problem Statement
The main objective is to determine the probability 𝑝 that a system percolates, given that each site is independently open with probability 𝑝. By averaging this probability within a large number of trials, it's possible to get within a certain confidence interval the real threshold of a percolation system.

<img width="560" alt="image" src="https://github.com/fsbonilha/PercolationUF/assets/54900275/982e3ec0-9951-473e-9ea2-5ac8906f341e">

<img width="225" alt="image" src="https://github.com/fsbonilha/PercolationUF/assets/54900275/e52a3c2e-c0c3-47d6-8851-e68808eacc7e">



## Real-World Applications
Estimating the percolation threshold via Monte Carlo simulation has significant real-world applications across various scientific and engineering fields. In materials science, understanding the percolation threshold is crucial for designing composite materials with desired electrical conductivity properties. For instance, in creating conductive polymers or composite insulators, knowing the percolation threshold helps determine the minimum concentration of conductive components required to achieve electrical connectivity. In geology and hydrology, percolation models are used to predict the movement of fluids through porous media, which is essential for groundwater management, oil recovery, and understanding the spread of contaminants. Additionally, percolation theory is applied in epidemiology to model the spread of diseases through populations, helping to inform public health interventions by identifying critical vaccination thresholds to prevent outbreaks. The insights gained from percolation simulations thus play a vital role in advancing technology, improving resource management, and safeguarding public health.





