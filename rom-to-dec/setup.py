from setuptools import setup, find_packages

import romtodec

setup(
    name=romtodec.__name__,
    version=romtodec.__version__,
    author='Caravana Cloude',
    author_email='code@caravana.cloud',
    description='Example for a minimal Python project with pytest support',
    packages=find_packages(),
    install_requires=[],  # e.g. ['numpy >= 1.11.1', 'matplotlib >= 1.5.1']
)