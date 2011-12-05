package br.uff.ic.ubicomp.testes.knowledge;

interface IMyResourceService {
		
		void createResource(String name, String id, int onOff, float x, float y);
		String getResource();
}
